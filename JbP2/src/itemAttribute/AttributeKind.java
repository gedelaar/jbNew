package itemAttribute;

import java.util.ArrayList;
import java.util.List;
import static itemAttribute.EnumAttributeKey.XMLAttributes.*;
import static itemAttribute.EnumAttributeValue.XMLAttributeValues.*;

public class AttributeKind implements AttributeAdapter {
  private AttributeKey attributeKey;
  private AttributeValue attributeValue = null;
  List<AttributeValue> attributeValues = new ArrayList<>();

  public AttributeKind(String value) {
    attributeKey = new AttributeKey(KIND.toString());
    setAttributeValue(value);
  }

  @Override
  public String getKey() {
    return attributeKey.getKey();
  }

  @Override
  public boolean checkValue(String value) {
    AttributeValue attValue = new AttributeValue(value.toUpperCase());
    return (attributeValues.contains(attValue));
  }

  public List<AttributeValue> attributeValue() {
    attributeValues.add(new AttributeValue(IMAGE.toString().toLowerCase()));
    attributeValues.add(new AttributeValue(TEXT.toString().toLowerCase()));
    return attributeValues;
  }

  @Override
  public void setAttributeValue(String value) {
    if (checkValue(value)) {
      attributeValue = new AttributeValue(value);
    }
  }

  @Override
  public String getValue() {
    return attributeValue.toString();
  }
}
