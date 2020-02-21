package slideFactory;

import java.util.ArrayList;
import java.util.List;

import slide.OrdinarySlide;
import slide.Slide;

public class OrdinarySlideFactory implements SlideAbstractFactory {

	List<Slide> slide = new ArrayList<>();
	
	@Override
	public Slide createSlide(String naam) {
		
		return new OrdinarySlide(naam);
	}

	@Override
	public Slide getSlide() {
		
		return (Slide) slide;
	}

	

}
