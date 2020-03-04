package itemAttribute;

import static itemAttribute.EnumAttributeKey.XMLAttributes.LEVEL;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class AttributeKeyLevel implements AttributeAdapter {
  private AttributeKey attributeKey;
  private AttributeValue attributeValue = null;
  List<AttributeValue> attributeValues = new ArrayList<>();

  public AttributeKeyLevel(String value) {
    attributeKey = new AttributeKey(LEVEL.toString());
    setAttributeValue(value);
  }

  @Override
  public String getKey() {
    return attributeKey.getKey();
  }

  @Override
  public boolean checkValue(String value) {
	  System.out.println(getClass()+" Level "+ value);
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

@Override
public String getValue() {
	return attributeValue.getValue().toLowerCase() ;
}
}
