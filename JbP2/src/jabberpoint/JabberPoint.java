package jabberpoint;

import java.util.ArrayList;
import java.util.List;

import presentation.IPresentation;
import presentation.SlideShow;
import slideFactory.SlideAbstractFactory;

public class JabberPoint {

  public static void main(String[] args) {
    IPresentation presentation = new SlideShow();
    presentation.load();

    List<SlideAbstractFactory> slideList = new ArrayList<>();
    slideList = presentation.open();
    SlideShow slideShow = new SlideShow();
    slideShow.checkSlideList(slideList);

    System.out.println("hello");

  }

}
