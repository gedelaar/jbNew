package zz_archive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import item.Item;
import item.ItemAttribute;
import item.TextItem;

//bouwt de overige nodes op
public class XmlElementNode {

  public List<Item> xmlElementNode(NodeList nodeList)
       {
    List<Item> items = new ArrayList<>();
    List<ItemAttribute> itemAtts = new ArrayList<ItemAttribute>();
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node tempNode = nodeList.item(i);

      // Ensure that the node is Element node
      if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
	System.out.println("Node Name :- " + tempNode.getNodeName() + " STARTS");
	System.out.println("Node Value :- " + tempNode.getTextContent() + " STARTS");
	// PrintXml printXml = new PrintXml();
	// printXml.transForm(nodeList);

	XmlElementNodeItem readXMLNodeItem = new OrdinarySlideReadXMLNodeItem();
	itemAtts = readXMLNodeItem.SlideNode(tempNode);
	// System.out.println(getClass() + " 1=> " + itemAtts);
	if (!itemAtts.isEmpty()) {
	  // System.out.println(getClass() + " 2=> " + itemAtts);

	  // System.out.println(itemAtts.size());

	  Item item = new TextItem();
	  // System.out.println(getClass() + " 2a=> " + itemAtt);
	  item.setItemNaam("test");
	  System.out.println("item:" + item);
	  // System.out.println(item.itemAttributes());

	  // item.itemAttributes().addAll(itemAtts);
	  item.setItemAttributes(itemAtts);
	  // item.setItemNaam(tempNode.getTextContent());
	  item.setLine(tempNode.getTextContent());
	  // item.itemAttributes().addAll(itemAtts);

	  // item.ItemAttributes().addAll(itemAtts);
	  // System.out.println(getClass() + "3->
	  // item.ItemAttributes().add(itemAtts.get(0));item: " + item);
	  items.add(item);
	  System.out.println(item.itemAttributes());
	  System.out.println(item);

	  // System.exit(3);
	}

      }

      if (tempNode.hasChildNodes()) {
	// Check if child nodes present.
	xmlElementNode(tempNode.getChildNodes());

      }
      // System.exit(3);
    }
    System.out.println(getClass() + " => " + items.size());
    System.out.println();
    //System.out.println(items);
    //System.exit(0);
    return items;
  }

}
