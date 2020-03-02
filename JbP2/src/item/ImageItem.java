package item;

import java.awt.Image;
import java.util.List;

import itemAttribute.Attribute;
import itemAttribute.Line;

public class ImageItem extends Item {
  private Line line;
  private String naam;
  private Image image;
  private List<Attribute> itemAttributes;

  @Override
  public Line getLine() {
    return this.line;
  }

  @Override
  public void setLine(Line line) {
    this.line = line;
  }

  @Override
  public void writeLine() {
  }

  @Override
  public void setNaam(String naam) {
    this.naam = naam;
  }

  @Override
  public String getNaam() {
    return this.naam;
  }

  @Override
  public List<Attribute> itemAttributes() {
    return itemAttributes;
  }

  @Override
  public void setItemAttributes(List<Attribute> itemAttributes) {
    this.itemAttributes = itemAttributes;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ImageItem [line=");
    builder.append(line);
    builder.append(", naam=");
    builder.append(naam);
    builder.append(", itemAttributes=");
    builder.append(itemAttributes);
    builder.append("]");
    return builder.toString();
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

}
