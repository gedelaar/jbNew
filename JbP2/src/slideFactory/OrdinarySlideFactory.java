package slideFactory;

import slide.OrdinarySlide;
import slide.Slide;

public class OrdinarySlideFactory implements SlideAbstractFactory {

  Slide ordinarySlide = new OrdinarySlide();

  @Override
  public Slide createSlide(Slide slide) {
    this.ordinarySlide = slide;
    return slide;
  }

  @Override
  public Slide getSlide() {
    return this.ordinarySlide;
  }

}
