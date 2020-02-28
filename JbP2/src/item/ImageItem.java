package item;

import java.util.List;

public class ImageItem extends Item {
  private String line;
  private String naam;
  private List<Attribute> itemAttributes;

  @Override
  public String getLine() {
    return this.line;
  }

  @Override
  public void setLine(String line) {
    this.line = line;
  }

  @Override
  public void writeLine() {
  }

  @Override
  public void setItemNaam(String naam) {
    this.naam = naam;
  }

  @Override
  public String getItemNaam() {
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

}
