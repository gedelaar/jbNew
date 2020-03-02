package presentation;

import slideshow.SlideShow;

public interface IPresentation {

  SlideShow load();

  //void save();

  // List<SlideAbstractFactory> open();
  SlideShow open();

  void save(SlideShow slideShow);

}