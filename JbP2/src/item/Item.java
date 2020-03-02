package item;

import java.util.List;

import xml.xmlenum.XMLType.XMLTypes;

public abstract class Item {
  private String naam;
  private String type;

  public abstract void setLine(String line);

  public abstract String getLine();

  public abstract void writeLine();

  public abstract void setItemNaam(String naam);

  public abstract String getItemNaam();

  public abstract void setItemAttributes(List<Attribute> itemAttributes);

  public abstract List<Attribute> itemAttributes();

  public abstract String setItemType(XMLTypes ITEM);

  public String getType() {
    return this.naam;
  };

}
