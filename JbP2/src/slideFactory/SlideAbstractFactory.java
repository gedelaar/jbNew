package slideFactory;

import slide.Slide;

public interface SlideAbstractFactory {

	public Slide createSlide(String naam);
	public Slide getSlide();

}
