package slideFactory;

import slide.OrdinarySlide;
import slide.Slide;

public class OrdinarySlideFactory implements SlideAbstractFactory {

  Slide ordinarySlide = new OrdinarySlide();

  @Override
  public Slide createSlide(Slide slide) {
    ordinarySlide = (OrdinarySlide) slide;
    return ordinarySlide;
  }

  @Override
  public OrdinarySlide getSlide(int index) {
    return (OrdinarySlide) ordinarySlide.getItem(index);
  }

  
}
