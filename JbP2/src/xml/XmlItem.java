package xml;

import java.util.List;

import org.w3c.dom.Node;

import item.Attribute;
import item.ImageItem;
import item.Item;
import item.TextItem;
import xml.xmlenum.XMLAttributeValue.XMLAttributeValues;

public class XmlItem {

  public Item itemValueXMLWrapper(Node node) {
    String naam = node.getNodeName();
    String line = node.getTextContent();

    List<Attribute> attributes = null;
    XmlItemAttribute xmlItemAttribute = new XmlItemAttribute();
    Item item = null;

    if (node.hasAttributes()) {
      attributes = xmlItemAttribute.AttributeXMLWrapper(node);
      item = getItemType(attributes);
      item.setItemAttributes(attributes);
    }

    item = setItemValues(naam, line, attributes);
    return item;

  }

  public Item setItemValues(String naam, String line, List<Attribute> attributes) {
    Item item = null;

    if (null != attributes) {
      item = getItemType(attributes);
      item.setItemAttributes(attributes);
    }

    if (null == item) {
      item = new TextItem();
    }
    item.setItemNaam(naam);
    item.setLine(line);
    return item;
  }

  private Item getItemType(List<Attribute> attributes) {
    for (int i = 0; i < attributes.size(); i++) {
      XMLAttributeValues attrValue = XMLAttributeValues.valueOf(attributes.get(i).getValue().toUpperCase());
      switch (attrValue) {
	case IMAGE:
	  return new ImageItem();
	default:
	  return new TextItem();
      }
    }
    return new TextItem();
  }
}
