package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import slide.Slide;
import slideFactory.OrdinarySlideFactory;
import slideFactory.SlideAbstractFactory;
import xml.ReadXMLFile;

@XmlRootElement (name = "presentation")
public class SlideShow implements IPresentation {
  /**
   * <pre>
   *           0..1     0..*
   * SlideShow ------------------------> Slide
   *           slideShow        &gt;       slide
   * </pre>
   */

  List<SlideAbstractFactory> slideFactory = new ArrayList<>();
  


  String showTitle;

  @Override
  public IPresentation load() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void save() {
    // TODO Auto-generated method stub

  }

  
  public List<SlideAbstractFactory> open() {

    ReadXMLFile xmlFile = new ReadXMLFile();
    List<SlideAbstractFactory> slides = new ArrayList<>();
    // lees de xml file
    slides = xmlFile.readXML();
    System.out.println(slides.isEmpty());
    System.out.println(slides.size());
    System.out.println(slides.toString());
    return slides;

  }

  public void checkSlideList(List<SlideAbstractFactory> slideList) {

    for (SlideAbstractFactory slideFactory : slideList) {
      // for (SlideFactory slideF : slideFactory) {

      //Slide slide = slideFactory.getSlide(0);
      System.out.println( slideFactory);
      //System.out.println("slidenaam : " + slide.getNaam());
      //System.out.println("slideItems: " + slide.items());
      // }
    }

  }

 
  public String getShowTitle() {
    return showTitle;
  }

  @XmlElement(name = "showtitle")
  public void setShowTitle(String showTitle) {
    this.showTitle = showTitle;
  }
  
  Slide slide;
  @XmlElement(name = "slide")
  public void setSlide(Slide slide) {
    this.slide = slide;
  }
  
  public Slide getSlide() {
    return slide;
  }
}
