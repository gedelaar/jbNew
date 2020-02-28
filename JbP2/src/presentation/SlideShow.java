package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.xml.sax.SAXException;

import item.Attribute;
import item.Item;
import slide.Slide;
import slideFactory.SlideAbstractFactory;
import xml.RecursiveDOM;

@XmlRootElement(name = "presentation")
public class SlideShow implements IPresentation {
  /**
   * <pre>
   *           0..1     0..*
   * SlideShow ------------------------> Slide
   *           slideShow        &gt;       slide
   * </pre>
   */

  List<SlideAbstractFactory> slideFactories = new ArrayList<>();

  String showTitle;
  Slide slide;

  @Override
  public IPresentation load() {
    return null;
  }

  @Override
  public void save() {
  }

  // lees de xml file
  public List<SlideAbstractFactory> open() {
    List<SlideAbstractFactory> slideAbstractFactories = null;
    try {
      RecursiveDOM recursiveDom = new RecursiveDOM();
      slideAbstractFactories = recursiveDom.recursiveDOM();
      System.out.println("  ");

      for (SlideAbstractFactory slideAbsFact : slideAbstractFactories) {
	System.out.println(slideAbsFact.getSlide().getNaam());

	for (Item item : slideAbsFact.getSlide().items()) {
	  System.out.println(item);
	  for (Attribute att : item.itemAttributes()) {
	    System.out.println(att);
	  }
	}
	System.out.println("  ");
      }
    }
    catch (SAXException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return slideAbstractFactories;
  }

  public void checkSlideList(List<SlideAbstractFactory> slideList) {

  }

  public String getShowTitle() {
    return showTitle;
  }

  public void setShowTitle(String showTitle) {
    this.showTitle = showTitle;
  }

  public void setSlide(Slide slide) {
    this.slide = slide;
  }

  public Slide getSlide() {
    return slide;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SlideShow [slideFactories=");
    builder.append(slideFactories);
    builder.append(", showTitle=");
    builder.append(showTitle);
    builder.append(", slide=");
    builder.append(slide);
    builder.append("]");
    return builder.toString();
  }
}
