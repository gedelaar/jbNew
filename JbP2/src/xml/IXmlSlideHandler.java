package xml;

import org.w3c.dom.Element;

import slideFactory.SlideAbstractFactory;

public interface IXmlSlideHandler {

  SlideAbstractFactory handleXmlSlide(Element e, boolean isFirstSlide);

}