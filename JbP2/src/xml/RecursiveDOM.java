package xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import slide.Slide;
import slideFactory.OrdinarySlideFactory;
import slideFactory.SlideAbstractFactory;
import slideFactory.TitleSlideFactory;
import xml.xmlenum.XMLType.XMLTypes;

public class RecursiveDOM {

  public List<SlideAbstractFactory> recursiveDOM() throws SAXException, IOException {

    Document doc = ConvertToXmlDocument.convertFileToXMLDocument();
    List<SlideAbstractFactory> slideAbstractFactories = new ArrayList<>();
    parse(doc, doc.getDocumentElement(), slideAbstractFactories);

    return slideAbstractFactories;
  }

  private void parse(final Document doc, final Element e, List<SlideAbstractFactory> slideAbstractFactories) {
    final NodeList children = e.getChildNodes();
    XMLTypes slideType = xml.xmlenum.XMLType.XMLTypes.SLIDE;
    XMLTypes showtitleType = xml.xmlenum.XMLType.XMLTypes.SHOWTITLE;

    for (int i = 0; i < children.getLength(); i++) {
      final Node n = children.item(i);
      if (n.getNodeType() == Node.ELEMENT_NODE) {

	if (n.getNodeName().equals(slideType.toXMLLowerCaseValue())) {
	  Slide slide = (new XmlSlideHandler()).handleXmlSlide(doc, (Element) n, slideAbstractFactories);
	  if (null != slide) {
	    SlideAbstractFactory ordinarySlideFactory = new OrdinarySlideFactory();
	    ordinarySlideFactory.createSlide(slide);
	    slideAbstractFactories.add(ordinarySlideFactory);
	  }
	}

	if (n.getNodeName().equals(showtitleType.toXMLLowerCaseValue())) {
	  Slide slide = (new XmlTitleSlideHandler()).handleXmlSlideElement((Element) n);
	  if (null != slide) {
	    SlideAbstractFactory titleSlideFactory = new TitleSlideFactory();
	    titleSlideFactory.createSlide(slide);
	    slideAbstractFactories.add(titleSlideFactory);
	  }
	}
	parse(doc, (Element) n, slideAbstractFactories);
      }
    }
  }
}
