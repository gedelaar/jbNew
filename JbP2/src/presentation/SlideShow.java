package presentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import slideFactory.SlideAbstractFactory;
import xml.ReadXMLByLoopingNode;

public class SlideShow implements Presentation {
	/**
	 * <pre>
	 *           0..1     0..*
	 * SlideShow ------------------------> Slide
	 *           slideShow        &gt;       slide
	 * </pre>
	 */
	private Set<SlideAbstractFactory> slide;

	public Set<SlideAbstractFactory> getSlide() {
		if (this.slide == null) {
			this.slide = new HashSet<SlideAbstractFactory>();
		}
		return this.slide;
	}

	List<SlideAbstractFactory> slideFactory = new ArrayList<>();

	@Override
	public Presentation load() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	public set<SlideAbstractFactory> open() {

		ReadXMLByLoopingNode xml = new ReadXMLByLoopingNode();
		// SlideAbstractFactory factory = new OrdinarySlideFactory();
		// slide.add(factory);
		slide.add((SlideAbstractFactory) xml.readXML());

		// System.out.println();

		// SlideAbstractFactory factory = new TitleSlideFactory();
		/*
		 * Slide slide = factory.createSlide("Title");
		 * System.out.println(slide.getNaam());
		 * 
		 * SlideAbstractFactory ordinaryFactory = new OrdinarySlideFactory();
		 * System.out.println(ordinaryFactory.createSlide("Ordinary"));
		 * 
		 * SlideAbstractFactory specialFactory = new SpecialSlideFactory(); Slide
		 * specialSlide = specialFactory.createSlide("Special");
		 * System.out.println(specialSlide.getNaam());
		 */
		return (set<SlideAbstractFactory>) slide;
	}

}
