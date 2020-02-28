package xml;

public class XmlTitle implements XmlNode  {
  String title=null;
  String subTitle=null;

  public XmlTitle(String title) {
    super();
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("XmlTitle [title=");
    builder.append(title);
    builder.append(", subTitle=");
    builder.append(subTitle);
    builder.append("]");
    return builder.toString();
  }
  

}
