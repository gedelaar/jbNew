package itemAttribute;

public interface AttributeAdapter {

  String getKey();
  String getValue();

  boolean checkValue(String value);

  void setAttributeValue(String value);

}
