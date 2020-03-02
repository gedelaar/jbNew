package xml;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import item.Item;
import slide.OrdinarySlide;
import slide.Slide;
import slide.TitleSlide;
import slideFactory.OrdinarySlideFactory;
import slideFactory.SlideAbstractFactory;
import slideFactory.TitleSlideFactory;
import xml.xmlenum.XMLType.XMLTypes;

public class XmlSlideHandler {

  public SlideAbstractFactory handleXmlSlideWrapper(final Element element, boolean isFirstSlide) {
    Slide slide = getSlide(isFirstSlide);
    SlideAbstractFactory slideAbstractFactory = getSlideAbstractFactory(isFirstSlide);
    
    parse(element, slide);
    slideAbstractFactory.createSlide(slide);
    return slideAbstractFactory;
  }

  public SlideAbstractFactory handleSlide(List<Item> items, boolean isFirstSlide) {

    Slide slide = getSlide(isFirstSlide);
    SlideAbstractFactory slideAbstractFactory = getSlideAbstractFactory(isFirstSlide);

    slide.items().addAll(items);

    slideAbstractFactory.createSlide(slide);
    return slideAbstractFactory;
  }

  private Slide getSlide(boolean isFirstSlide) {
    if (isFirstSlide) {
      return new TitleSlide();
    }
    return new OrdinarySlide();
  }

  private SlideAbstractFactory getSlideAbstractFactory(boolean isFirstSlide) {
    if (isFirstSlide) {
      return new TitleSlideFactory();
    }
    return new OrdinarySlideFactory();
  }

  private void parse(final Element e, Slide slide) {
    final NodeList children = e.getChildNodes();

    for (int i = 0; i < children.getLength(); i++) {
      final Node n = children.item(i);
      if (n.getNodeType() == Node.ELEMENT_NODE) {
	XMLTypes nodeName = XMLTypes.valueOf(n.getNodeName().toUpperCase());
	switch (nodeName) {
	  case TITLE:
	  case ITEM:
	    slide.items().add((new XmlItem()).itemValueXMLWrapper(n));
	    break;
	  default:
	    break;
	}
	parse((Element) n, slide);
      }
    }
  }

}
