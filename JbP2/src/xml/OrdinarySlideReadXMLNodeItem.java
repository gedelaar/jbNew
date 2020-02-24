package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

import item.Item;
import item.NodeAttribute;
import item.TextItem;

public class OrdinarySlideReadXMLNodeItem implements ReadXMLNodeItem {

  Item item;
  NodeAttribute nodeAttribute;
  List<NodeAttribute> atts = new ArrayList<>();

  @Override
  public Item SlideNode(Node node) {

    item = new TextItem(node.getTextContent());
    item.setNodeNaam(node.getNodeName());

    if (node.hasAttributes()) {
      // get attributes names and values
      XmlNodeAttribute xmlNodeAttribute = new XmlNodeAttribute();
      nodeAttribute = xmlNodeAttribute.getXMLAttributes(node);
      atts.add(nodeAttribute);
      // nodeAttribute.setNaam(item.getNodeNaam());
      // nodeAttribute.setValue(item.getLine());
      System.out.println(atts.toString());
    }
    return item;
  }

}
