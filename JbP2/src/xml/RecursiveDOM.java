package xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import slideFactory.SlideAbstractFactory;
import slideshow.SlideShow;
import xml.xmlenum.XMLType.XMLTypes;

public class RecursiveDOM {
  List<SlideAbstractFactory> slideAbstractFactories = new ArrayList<>();
  boolean isFirstSlide = true;


  public SlideShow recursiveDOM() throws SAXException, IOException {

    Document doc = ConvertToXmlDocument.convertFileToXMLDocument();
    SlideShow slideShow = new SlideShow();
    parse(doc.getDocumentElement(), slideShow);
    slideShow.slideAbstractFactories().addAll(slideAbstractFactories);

    return slideShow;
  }
 
  private void parse(final Element e, SlideShow slideShow) {
    final NodeList children = e.getChildNodes();

    for (int i = 0; i < children.getLength(); i++) {
      final Node n = children.item(i);
      if (n.getNodeType() == Node.ELEMENT_NODE) {

	XMLTypes nodeName = XMLTypes.valueOf(n.getNodeName().toUpperCase());
	switch (nodeName) {
	  case SLIDE:
	    SlideAbstractFactory slideAbstractFactory = (new XmlSlideHandler()).handleXmlSlideWrapper((Element) n,
		isFirstSlide);
	    if (null != slideAbstractFactory) {
	      isFirstSlide = false;
	      slideAbstractFactories.add(slideAbstractFactory);
	    }
	    break;
	  case SHOWTITLE:
	    slideShow.setShowTitle(n.getTextContent());
	    break;
	  case SHOWSUBTITLE:
	    slideShow.setShowTitle(n.getTextContent());
	    break;

	  default:
	    break;
	}
	parse((Element) n, slideShow);
      }
    }
  }
}
