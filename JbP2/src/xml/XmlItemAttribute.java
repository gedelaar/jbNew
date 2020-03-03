package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import itemAttribute.AttributeAdapter;
import itemAttribute.AttributeKind;
import itemAttribute.AttributeLevel;

public class XmlItemAttribute {
  List<AttributeAdapter> attributes = new ArrayList<>();

  public List<AttributeAdapter> AttributeXMLWrapper(Node tempNode) {
    NamedNodeMap nodeMap = tempNode.getAttributes();

    for (int j = 0; j < nodeMap.getLength(); j++) {
      AttributeAdapter attribute;
      Node node = nodeMap.item(j);

      AttributeKind attributeKind = new AttributeKind(node.getNodeValue());
      if (attributeKind != null) {
	attributes.add(attributeKind);
      }
      AttributeLevel attributeLevel = new AttributeLevel(node.getNodeValue());
      if (attributeLevel != null) {
	attributes.add(attributeLevel);
      }
    }
    return this.getAttributes();
  }

  public AttributeAdapter setAttributeKind(String kind) {
    AttributeAdapter attribute = new AttributeKind(kind);
    return attribute;
  }

  public AttributeAdapter setAttributeLevel(String level) {
    AttributeAdapter attribute = new AttributeLevel(level);
    return attribute;
  }

  public List<AttributeAdapter> getAttributes() {
    return attributes;
  }
}
