package item;

import java.util.List;

public abstract class Item {

  public abstract void setLine(String line);

  public abstract String getLine();

  public abstract void writeLine();

  public abstract void setItemNaam(String naam);

  public abstract String getItemNaam();

  public abstract void setItemAttributes(List<Attribute> itemAttributes);

  public abstract List<Attribute> itemAttributes();

}
