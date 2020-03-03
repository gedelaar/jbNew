package itemAttribute;

public interface Attribute {

  AttributeKind getAttributeKey();

  void setAttributeKey(AttributeKind attributeKey);

  AttributeValue getAttributeValue();

  void setAttributeValue(AttributeValue attributeValue);
}
