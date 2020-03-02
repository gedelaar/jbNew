package presentation;

import slideshow.SlideShow;

public interface IPresentation {

  SlideShow load();

  SlideShow open();

  void save(SlideShow slideShow);

}