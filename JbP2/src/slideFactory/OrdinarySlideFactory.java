package slideFactory;

import slide.OrdinarySlide;
import slide.Slide;

public class OrdinarySlideFactory implements SlideAbstractFactory {

  Slide ordinarySlide = new OrdinarySlide();
  //Slide ordinarySlide;

  @Override
  public Slide createSlide(Slide slide) {
    //System.out.println(this.getClass() + " createSlide " + slide);
    this.ordinarySlide = slide;
    return slide;
  }

  @Override
  public Slide getSlide() {
    //System.out.println(this.getClass() + " getSlide " + ordinarySlide);
    return this.ordinarySlide;
  }

}
