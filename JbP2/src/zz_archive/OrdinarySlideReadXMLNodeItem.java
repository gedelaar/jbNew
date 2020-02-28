package zz_archive;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

import item.ItemAttribute;

public class OrdinarySlideReadXMLNodeItem implements XmlElementNodeItem {

 // NodeAttribute nodeAttribute = null;

  //ItemAttribute itemAtt = new ItemAttribute();

  @Override
  public List<ItemAttribute> SlideNode(Node node) {
    List<ItemAttribute> atts = new ArrayList<>();
    if (node.hasAttributes()) {
      // get attributes names and values
      XmlNodeAttribute xmlNodeAttribute = new XmlNodeAttribute();
      atts.addAll(xmlNodeAttribute.getXMLAttributes(node));
      System.out.println(getClass() + " 1-> " + atts);
      System.out.println(getClass() + " 2-> " + node.getNodeName());
      System.out.println(getClass() + " 3-> " + node.getTextContent());
      //System.exit(0);
    }
    return atts;
  }

}
