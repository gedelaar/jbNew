package item;

import java.util.ArrayList;
import java.util.List;

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
	return "TextItem [line=" + line + ", naam=" + naam + ", itemAttributes=" + itemAttributes + "]";
}

  @Override
  public void setLine(Line line) {

    this.line = line;
  }
}
