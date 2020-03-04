package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import itemAttribute.AttributeAdapter;
import itemAttribute.AttributeKeyKind;
import itemAttribute.AttributeKeyLevel;

public class XmlItemAttribute {
  List<AttributeAdapter> attributes = new ArrayList<>();
  AttributeAdapter attributeKind;
  AttributeAdapter attributeLevel;

  public List<AttributeAdapter> AttributeXMLWrapper(Node tempNode) {
    NamedNodeMap nodeMap = tempNode.getAttributes();

    for (int j = 0; j < nodeMap.getLength(); j++) {
      Node node = nodeMap.item(j);

      try {
	attributeKind = new AttributeKeyKind(node.getNodeValue());
	attributes.add(attributeKind);
      }
      catch (Exception e) {
      }
      try {
	AttributeAdapter attributeLevel = new AttributeKeyLevel(node.getNodeValue());
	attributes.add(attributeLevel);
      }
      catch (Exception e) {
      }
    }
    return this.getAttributes();
  }

  public AttributeAdapter setAttributeKind(String kind) {
    AttributeAdapter attribute = new AttributeKeyKind(kind);
    return attribute;
  }

  public AttributeAdapter setAttributeLevel(String level) {
    AttributeAdapter attribute = new AttributeKeyLevel(level);
    return attribute;
  }

  public List<AttributeAdapter> getAttributes() {
    return attributes;
  }
}
