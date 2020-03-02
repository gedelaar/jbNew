package slideFactory;

import slide.Slide;

public interface SlideAbstractFactory {

  public Slide createSlide(Slide slide);

  public Slide getSlide();

}
