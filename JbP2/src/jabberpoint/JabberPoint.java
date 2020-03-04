package jabberpoint;

import presentation.IPresentation;
import presentation.Presentation;
import slideshow.SlideShow;

public class JabberPoint {

  public static void main(String[] args) {
    IPresentation presentation = new Presentation();
    SlideShow slideShowDemo= presentation.load();
    
    presentation.save(slideShowDemo);
    SlideShow slideShow = presentation.open();
    presentation.save(slideShow);
  }

}
