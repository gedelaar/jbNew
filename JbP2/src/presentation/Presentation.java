package presentation;

import java.io.IOException;

import org.xml.sax.SAXException;

import demo.DemoPresentation;
import item.Item;
import itemAttribute.Attribute;
import slideFactory.SlideAbstractFactory;
import slideshow.SlideShow;
import slideshow.SlideShowSave;
import xml.RecursiveDOM;

public class Presentation implements IPresentation {

  // load demo presentation
  @Override
  public SlideShow load() {
    DemoPresentation demoPresentation = new DemoPresentation();
    SlideShow slideShow = demoPresentation.loadFile();
    return slideShow;

  }

  @Override
  public void save(SlideShow slideShow) {
    SlideShowSave slideShowSave = new SlideShowSave();
    try {
      slideShowSave.saveSlideShow(slideShow);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public SlideShow open() {

    SlideShow slideShow = new SlideShow();
    RecursiveDOM recursiveDom = new RecursiveDOM();

    try {
      slideShow = recursiveDom.recursiveDOM();
    }
    catch (SAXException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    // checkSlideShow(slideShow);
    return slideShow;

  }

  private void checkSlideShow(SlideShow slideShow) {
    System.out.println("slideshow: " + slideShow.toString());
    for (SlideAbstractFactory slideAbF : slideShow.slideAbstractFactories()) {
      System.out.println("");
      System.out.println("  slideAbF: " + slideAbF.toString());
      System.out.println("  slides: " + slideAbF.getSlide());
      for (Item item : slideAbF.getSlide().items()) {
	System.out.println("    slideItems: " + item);
	if (null != item.itemAttributes()) {
	  for (Attribute att : item.itemAttributes()) {
	    System.out.println("      Attribute" + att.toString());
	  }
	}
      }
    }
  }
}
