package itemAttribute;

public class ItemAttribute implements Attribute {
  private AttributeKind attributeKey;
  private AttributeValue attributeValue;

  public AttributeKind getAttributeKey() {
    return attributeKey;
  }

  public void setAttributeKey(AttributeKind attributeKey) {
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
