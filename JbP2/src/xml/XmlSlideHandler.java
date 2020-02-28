package xml;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import slide.OrdinarySlide;
import slide.Slide;
import slideFactory.SlideAbstractFactory;

public class XmlSlideHandler implements IXmlSlideHandler {

  @Override
  public Slide handleXmlSlide(final Document doc, final Element e, List<SlideAbstractFactory> slideAbstractFactories) {

    Slide slide = new OrdinarySlide();
    parse(doc, (Element) e, slide);
    return slide;
  }

  private void parse(final Document doc, final Element e, Slide slide) {
    final NodeList children = e.getChildNodes();

    for (int i = 0; i < children.getLength(); i++) {
      final Node n = children.item(i);
      if (n.getNodeType() == Node.ELEMENT_NODE) {
	if (n.getNodeName().equals(xml.xmlenum.XMLType.XMLTypes.TITLE.toXMLLowerCaseValue())) {
	  slide.setNaam(new XmlTitle(n.getTextContent()).getTitle());
	}
	if (n.getNodeName().equals(xml.xmlenum.XMLType.XMLTypes.ITEM.toXMLLowerCaseValue())) {
	  slide.items().add((new XmlItem()).getItemValues(n));
	}
	parse(doc, (Element) n, slide);
      }
    }

  }

  @Override
  public Slide handleXmlSlideElement(Element e) {
    // TODO Auto-generated method stub
    return null;
  }

}
