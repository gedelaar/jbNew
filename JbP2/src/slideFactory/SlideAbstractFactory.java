package slideFactory;

import slide.Slide;

public interface SlideAbstractFactory {

 /// Slide slide=null;

  // public Slide createSlide(String naam);
  public Slide createSlide(Slide slide);

  public Slide getSlide();

}
