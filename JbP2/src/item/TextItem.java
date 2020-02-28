package item;

import java.util.List;

public class TextItem extends Item {
  private String line;
  private String naam;
  private List<Attribute> itemAttributes;

  public TextItem(String line) {
    super();
    this.line = line;
  }

  public TextItem() {
  }

  public String getLine() {
    return line;
  }

  public void writeLine() {
  }

  public void setItemNaam(String naam) {
    this.naam = naam;
  }

  public String getItemNaam() {
    return this.naam;
  }

  @Override
  public void setLine(String line) {
    this.line = line;
  }

  @Override
  public void setItemAttributes(List<Attribute> itemAttributes) {
    this.itemAttributes = itemAttributes;

  }

  @Override
  public List<Attribute> itemAttributes() {
    return itemAttributes;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("TextItem [line=");
    builder.append(line);
    builder.append(", naam=");
    builder.append(naam);
    builder.append(", itemAttributes=");
    builder.append(itemAttributes);
    builder.append("]");
    return builder.toString();
  }

}
