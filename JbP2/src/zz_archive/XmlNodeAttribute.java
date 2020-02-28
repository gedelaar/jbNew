package zz_archive;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import item.ItemAttribute;

public class XmlNodeAttribute {

  //ItemAttribute itemAttribute = new ItemAttribute();
  List<ItemAttribute> itemAttributes = new ArrayList<>();

  public List<ItemAttribute> getXMLAttributes(Node tempNode) {
    NamedNodeMap nodeMap = tempNode.getAttributes();

    for (int j = 0; j < nodeMap.getLength(); j++) {
      ItemAttribute itemAttribute = new ItemAttribute();
      Node node = nodeMap.item(j);
      //System.out.println("Attribute Name : " + node.getNodeName());
      //System.out.println("Attribute Value : " + node.getNodeValue());

      itemAttribute.setNaam(node.getNodeName());
      itemAttribute.setValue(node.getNodeValue());
      itemAttributes.add(itemAttribute);

    }
    //System.out.println(getClass()+" -> "+itemAttributes);
    return itemAttributes;
  }
}
