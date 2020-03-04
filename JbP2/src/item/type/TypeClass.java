package item.type;

import java.util.Dictionary;
import java.util.Hashtable;

import item.ImageItem;
import item.Item;
import item.TextItem;

public class TypeClass {
  private static final Object TEXT = "TEXT";
  private static final Object IMAGE = "IMAGE";
  public Dictionary d = new Hashtable();

  public TypeClass() {
    d.put(TEXT, new TypeText());
    d.put(IMAGE, new TypeImage());
  }

  public class TypeText implements IitemType {
    protected static final String TEXT = "TEXT";

    @Override
    public Item getType() {
      return new TextItem();
    }

    @Override
    public String getTypeValue() {
      return TEXT;
    }

  }

  public class TypeImage implements IitemType {
    protected static final String IMAGE = "IMAGE";

    @Override
    public Item getType() {
      return new ImageItem();
    }

    @Override
    public String getTypeValue() {
      return IMAGE;
    }
  }

}