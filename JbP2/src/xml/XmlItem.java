package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

import item.ImageItem;
import item.Item;
import item.TextItem;
import itemAttribute.Attribute;
import itemAttribute.AttributeAdapter;
import itemAttribute.Line;
import itemAttribute.EnumAttributeValue.XMLAttributeValues;

public class XmlItem {

  public Item itemValueXMLWrapper(Node node) {
    String naam = node.getNodeName();
    Line line = new Line(node.getTextContent());

    List<AttributeAdapter> attributes = new ArrayList<>();
    XmlItemAttribute xmlItemAttribute = new XmlItemAttribute();
    Item item = null;

    if (node.hasAttributes()) {
      attributes = xmlItemAttribute.AttributeXMLWrapper(node);
      item = getItemType(attributes);
    }

    item = setItemValues(naam, line, attributes);
    return item;

  }

  public Item setItemValues(String naam, Line line, List<AttributeAdapter> attributes) {
    Item item = null;
    List<AttributeAdapter> listAttributes = new ArrayList<>();
    listAttributes = attributes;

    if (null != attributes) {
      item = getItemType(attributes);
      item.itemAttributes().addAll(listAttributes);
    }

    if (null == item) {
      item = new TextItem();
    }
    item.setNaam(naam);
    item.setLine(line);
    return item;
  }

  private Item getItemType(List<AttributeAdapter> attributes) {
    for (int i = 0; i < attributes.size(); i++) {
      XMLAttributeValues attrValue = XMLAttributeValues.valueOf(attributes.get(i).getKey());
      // attributes.get(i).getKey()

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
