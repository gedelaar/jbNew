package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import itemAttribute.Attribute;
import itemAttribute.ItemAttribute;

public class XmlItemAttribute {
  List<Attribute> attributes = new ArrayList<>();

  public List<Attribute> AttributeXMLWrapper(Node tempNode) {
    String naam = null;
    String value = null;
    NamedNodeMap nodeMap = tempNode.getAttributes();

    for (int j = 0; j < nodeMap.getLength(); j++) {
      Attribute attribute;
      Node node = nodeMap.item(j);

      naam = node.getNodeName();
      value = node.getNodeValue();
      attribute = setAttribute(naam, value);
      attributes.add(attribute);
    }
    return this.getAttributes();
  }

  public Attribute setAttribute(String naam, String value) {
    Attribute attribute = new ItemAttribute();
    attribute.setNaam(naam);
    attribute.setValue(value);
    return attribute;
  }

  public List<Attribute> getAttributes() {
    return attributes;
  }
}
