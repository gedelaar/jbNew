package slideFactory;

import slide.Slide;

public class SlideFactory {

		public static Slide getSlide(SlideAbstractFactory factory) {
			return factory.createSlide(null);
		}
}
