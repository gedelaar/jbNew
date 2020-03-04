package itemAttribute;

public class ItemAttribute implements Attribute {
  private AttributeKeyKind attributeKey;
  private AttributeValue attributeValue;

  public AttributeKeyKind getAttributeKey() {
    return attributeKey;
  }

  public void setAttributeKey(AttributeKeyKind attributeKey) {
    this.attributeKey = attributeKey;
  }

  public AttributeValue getAttributeValue() {
    return attributeValue;
  }

  public void setAttributeValue(AttributeValue attributeValue) {
    this.attributeValue = attributeValue;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ItemAttribute [naam=");
    builder.append(attributeKey);
    builder.append(", value=");
    builder.append(attributeValue);
    builder.append("]");
    return builder.toString();
  }

}
