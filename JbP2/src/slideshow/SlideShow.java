package slideshow;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import slideFactory.SlideAbstractFactory;

@JacksonXmlRootElement(localName = "presentation")
public class SlideShow implements ISlideShow {

  @JacksonXmlElementWrapper()
  private List<SlideAbstractFactory> slideAbstractFactories = new ArrayList<>();

  @JacksonXmlProperty(localName="showtitle")
  private String showTitle;
  @JacksonXmlProperty
  private String showSubTitle;
  @JacksonXmlProperty
  private String date;
  @JacksonXmlProperty
  private String presenterName;

  public String getShowTitle() {
    return showTitle;
  }

  public void setShowTitle(String showTitle) {
    this.showTitle = showTitle;
  }

  public String getShowSubTitle() {
    return showSubTitle;
  }

  public void setShowSubTitle(String showSubTitle) {
    this.showSubTitle = showSubTitle;
  }

  public String getPresenterName() {
    return presenterName;
  }

  public void setPresenterName(String presenterName) {
    this.presenterName = presenterName;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SlideShow [showTitle=");
    builder.append(showTitle);
    builder.append(", showSubTitle=");
    builder.append(showSubTitle);
    builder.append(", date=");
    builder.append(date);
    builder.append(", presenterName=");
    builder.append(presenterName);
    builder.append("]");
    return builder.toString();
  }

  public List<SlideAbstractFactory> slideAbstractFactories() {
    return slideAbstractFactories;
  }
  
  
  public void setDate(String date) {
    this.date = date;
  }

}
