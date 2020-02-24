package slideFactory;

import slide.Slide;

public interface SlideAbstractFactory {

	//public Slide createSlide(String naam);
	public Slide createSlide(Slide slide);
	public Slide getSlide(int index);

}
