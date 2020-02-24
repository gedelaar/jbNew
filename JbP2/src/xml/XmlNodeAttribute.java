package xml;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import item.ItemAttribute;
import item.NodeAttribute;

public class XmlNodeAttribute {

  NodeAttribute nodeAttribute = new ItemAttribute();

  public NodeAttribute getXMLAttributes(Node tempNode) {
    NamedNodeMap nodeMap = tempNode.getAttributes();

    for (int j = 0; j < nodeMap.getLength(); j++) {

      Node node = nodeMap.item(j);
      System.out.println("Attribute Name : " + node.getNodeName());
      System.out.println("Attribute Value : " + node.getNodeValue());

      nodeAttribute.setNaam(node.getNodeName());
      nodeAttribute.setValue(node.getNodeValue());

    }
    return nodeAttribute;
  }
}
