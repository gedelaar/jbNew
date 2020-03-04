package presentation;

import java.io.IOException;

import org.xml.sax.SAXException;

import demo.DemoPresentation;
import item.Item;
import itemAttribute.Attribute;
import itemAttribute.AttributeAdapter;
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
		checkSlideShow(slideShow);
		return slideShow;

	}

	@Override
	public void save(SlideShow slideShow) {
		SlideShowSave slideShowSave = new SlideShowSave();
		try {
			slideShowSave.saveSlideShow(slideShow);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public SlideShow open() {

		SlideShow slideShow = new SlideShow();
		RecursiveDOM recursiveDom = new RecursiveDOM();

		try {
			slideShow = recursiveDom.recursiveDOM();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
				System.out.println("    Item Line: " + item.getLine().getLine());
				if (null != item.itemAttributes()) {
					for (AttributeAdapter att : item.itemAttributes()) {
						System.out.println("      Attribute " + att.getKey() + " " + att.getValue());
					}
				}
			}
		}
	}
}
