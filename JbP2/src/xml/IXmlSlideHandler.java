package xml;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import slide.Slide;
import slideFactory.SlideAbstractFactory;

public interface IXmlSlideHandler {

  Slide handleXmlSlide(Document doc, Element e, List<SlideAbstractFactory> slideAbstractFactories);
  Slide handleXmlSlideElement(Element e);

}