package zz_archive;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import item.Item;
import slide.Slide;
import xml.xmlenum.XMLType.XMLTypes;

public class XmlSlideNode {
  Slide slide;

  // deze bouwt het slide object op
  public List<Slide> xmlSlideNode(NodeList nodeList)  {
    List<Slide> slideList = new ArrayList<>();
    List<Item> items = new ArrayList<>();

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node tempNode = nodeList.item(i);
      if (tempNode.getNodeName().toLowerCase().equals(XMLTypes.SLIDE.toXMLLowerCaseValue())) {
	System.out.println("Node Name :- " + tempNode.getNodeName() + " STARTS");
	System.out.println("Node Value :- " + tempNode.getTextContent() + " STARTS");
	XmlElementNode readXMLNode = new XmlElementNode();
	items = readXMLNode.xmlElementNode(nodeList);
	//if (items != null) {
	  if (!items.isEmpty()) {
	    //items = readXMLNode.xmlElementNode(nodeList);
	    slide.setItems(items);
	    //System.exit(0);
	// }
	}
      }

      if (tempNode.hasChildNodes()) {
	// Check if child nodes present.
	System.out.println("volgend niveau");
	System.out.println(tempNode.getChildNodes());
	xmlSlideNode(tempNode.getChildNodes());
	    //System.exit(0);

      }
      System.out.println("Node Name :- " + tempNode.getNodeName() + " ENDS");
      System.out.println("slidelist size:" + slideList.size());
      slideList.add(slide);
      System.out.println("--" + i + " " + nodeList.getLength());
      System.out.println();
	    //System.exit(0);

    }
    System.out.println("stopt");
    System.exit(0);

    return slideList;
  }
}