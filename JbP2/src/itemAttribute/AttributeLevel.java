package itemAttribute;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import static itemAttribute.EnumAttributeKey.XMLAttributes.*;
import static itemAttribute.EnumAttributeValue.XMLAttributeValues.*;

public class AttributeLevel implements AttributeAdapter {
  private AttributeKey attributeKey;
  private AttributeValue attributeValue = null;
  List<AttributeValue> attributeValues = new ArrayList<>();

  public AttributeLevel(String value) {
    attributeKey = new AttributeKey(LEVEL.toString());
    setAttributeValue(value);
  }

  @Override
  public String getKey() {
    return attributeKey.getKey();
  }

  @Override
  public boolean checkValue(String value) {
    int i = Integer.parseInt(value);
    Validate.inclusiveBetween(1, 4, i);
    return true;
  }

  @Override
  public void setAttributeValue(String value) {
    if (checkValue(value)) {
      attributeValue = new AttributeValue(value);
    }
  }
}
