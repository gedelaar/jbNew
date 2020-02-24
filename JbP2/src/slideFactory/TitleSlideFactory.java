package slideFactory;

import slide.Slide;
import slide.TitleSlide;

public class TitleSlideFactory implements SlideAbstractFactory {

	TitleSlide titleSlide = new TitleSlide();

	@Override
	public Slide createSlide(Slide slide) {
		titleSlide = (TitleSlide) slide;
		return new TitleSlide(titleSlide);
	}

	@Override
	public TitleSlide getSlide() {
		return titleSlide;
	}

	
}
