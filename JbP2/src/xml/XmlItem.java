package xml;

import java.util.List;

import org.w3c.dom.Node;

import item.ImageItem;
import item.Item;
import item.TextItem;
import itemAttribute.Attribute;
import itemAttribute.Line;
import xml.xmlenum.XMLAttributeValue.XMLAttributeValues;

public class XmlItem {

  public Item itemValueXMLWrapper(Node node) {
    String naam = node.getNodeName();
    Line line = new Line(node.getTextContent());

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

  public Item setItemValues(String naam, Line line, List<Attribute> attributes) {
    Item item = null;

    if (null != attributes) {
      item = getItemType(attributes);
      item.setItemAttributes(attributes);
    }

    if (null == item) {
      item = new TextItem();
    }
    item.setNaam(naam);
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
