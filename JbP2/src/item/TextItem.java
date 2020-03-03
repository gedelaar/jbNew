package item;

import java.util.ArrayList;
import java.util.List;

import itemAttribute.Attribute;
import itemAttribute.AttributeAdapter;
import itemAttribute.Line;

public class TextItem extends Item {
  private Line line;
  private String naam;
  private List<AttributeAdapter> itemAttributes = new ArrayList<>();

  public TextItem(Line line) {
    super();
    this.line = line;
  }

  public TextItem() {
  }

  @Override
  public Line getLine() {
    return line;
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
  public List<AttributeAdapter> itemAttributes() {
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

  @Override
  public void setLine(Line line) {

    this.line = line;
  }
}
