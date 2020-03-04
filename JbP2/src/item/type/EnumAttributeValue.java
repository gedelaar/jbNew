package item.type;

import item.ImageItem;
import item.Item;
import item.TextItem;

public class EnumAttributeValue {
  public enum XMLAttributeValues {
    TEXT {
      @Override
      public TextItem setItemType() {
	return new TextItem();
      }
    },
    IMAGE {
      @Override
      public ImageItem setItemType() {
	return new ImageItem();
      }

    };

    public abstract Item setItemType();
  }
}