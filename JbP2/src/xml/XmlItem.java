package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

import item.ImageItem;
import item.Item;
import item.TextItem;
import item.type.EnumAttributeValue.XMLAttributeValues;
import item.type.IitemType;
import item.type.TypeClass;
import item.type.TypeImage;
import itemAttribute.AttributeAdapter;
import itemAttribute.Line;

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
      System.out.println(attributes.get(i).getValue());
      TypeClass typeClass = new TypeClass();
      typeClass.d.get("IMAGE");
      typeClass.d.elements().equals(attributes.get(i).getValue().toUpperCase());
      typeClass.d.elements().asIterator().forEachRemaining(attributes.get(i).getValue().toUpperCase());
      .equals(attributes.get(i).getValue().toUpperCase());
      IitemType itemType;
     // itemType.getTypeValue() ;
      XMLAttributeValues attrValue = XMLAttributeValues.valueOf(attributes.get(i).getValue().toUpperCase());

     // if (attrValue.compareTo(new TypeImage().getTypeImage()) == 0) {
//	return item.type.EnumAttributeValue.XMLAttributeValues.setItemType();
    //  }

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
