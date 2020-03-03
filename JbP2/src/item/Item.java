package item;

import java.util.List;

import itemAttribute.Attribute;
import itemAttribute.AttributeAdapter;
import itemAttribute.Line;

public abstract class Item {

  public abstract void setLine(Line line);

  public abstract Line getLine();

  public abstract void writeLine();

  public abstract void setNaam(String naam);

  public abstract String getNaam();

  public abstract List<AttributeAdapter> itemAttributes();

}
