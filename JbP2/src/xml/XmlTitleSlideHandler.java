package xml;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import slide.Slide;
import slide.TitleSlide;
import slideFactory.SlideAbstractFactory;

public class XmlTitleSlideHandler implements IXmlSlideHandler {

  @Override
  public Slide handleXmlSlideElement(Element e) {
    Slide slide = new TitleSlide();
    slide.setNaam(new XmlTitle(e.getTextContent()).getTitle());
    return slide;
  }

  @Override
  public Slide handleXmlSlide(Document doc, Element e, List<SlideAbstractFactory> slideAbstractFactories) {
    // TODO Auto-generated method stub
    return null;
  }

}
