package xml;

import java.util.List;

import org.w3c.dom.Node;

import item.Attribute;
import item.ImageItem;
import item.Item;
import item.TextItem;

public class XmlItem {

  public Item getItemValues(Node n) {
    List<Attribute> attributes;
    XmlItemAttribute xmlItemAttribute = new XmlItemAttribute();
    Item item = null;

    if (n.hasAttributes()) {
      attributes = xmlItemAttribute.getXMLAttributes(n);
      switch (attributes.get(0).getValue()) {
	case "text":
	  item = new TextItem();
	  break;
	case "image":
	  item = new ImageItem();
	  break;

	default:
	  break;
      }

      if (null != item) {
	item.setItemNaam(n.getNodeName());
	item.setLine(n.getTextContent());

	item.setItemAttributes(attributes);

      }
    }
    return item;
  }
}
