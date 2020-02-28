package xml.xmlenum;

import xml.xmlenum.XMLType.XMLTypes;

public enum XMLAttributes {

  KIND, LEVEL;

  public String toXMLLowerCaseValue() {
    return this.name().toLowerCase();
  }

  public XMLTypes from(String status) {
    return XMLTypes.valueOf(status.toUpperCase());
  }

}
