package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import item.Attribute;
import item.ItemAttribute;

public class XmlItemAttribute {
  List<Attribute> itemAttributes = new ArrayList<>();

  public List<Attribute> getXMLAttributes(Node tempNode) {
    NamedNodeMap nodeMap = tempNode.getAttributes();

    for (int j = 0; j < nodeMap.getLength(); j++) {
      ItemAttribute itemAttribute = new ItemAttribute();
      Node node = nodeMap.item(j);

      itemAttribute.setNaam(node.getNodeName());
      itemAttribute.setValue(node.getNodeValue());
      itemAttributes.add(itemAttribute);

    }
    return itemAttributes;
  }
}
