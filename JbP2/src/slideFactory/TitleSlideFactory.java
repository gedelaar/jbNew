package slideFactory;

import slide.Slide;
import slide.TitleSlide;

public class TitleSlideFactory implements SlideAbstractFactory {

  Slide titleSlide = new TitleSlide();

  @Override
  public Slide createSlide(Slide slide) {
    this.titleSlide = slide;
    return slide;
  }

  @Override
  public Slide getSlide() {
    return this.titleSlide;
  }

}
