package slideFactory;

import slide.Slide;
import slide.TitleSlide;

public class TitleSlideFactory implements SlideAbstractFactory {

	@Override
	public Slide createSlide(String naam) {
	
		return new TitleSlide(naam);
	}

}
