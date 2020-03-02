package slideFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

import slide.OrdinarySlide;
import slide.Slide;

public class OrdinarySlideFactory implements SlideAbstractFactory {

  @JsonProperty("slide")
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
