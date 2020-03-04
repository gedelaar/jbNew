package itemAttribute;

public interface Attribute {

  AttributeKeyKind getAttributeKey();

  void setAttributeKey(AttributeKeyKind attributeKey);

  AttributeValue getAttributeValue();

  void setAttributeValue(AttributeValue attributeValue);
}
