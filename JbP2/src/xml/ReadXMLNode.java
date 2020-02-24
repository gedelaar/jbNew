package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import slide.OrdinarySlide;
import slide.Slide;
import xml.xmlenum.XMLType.XMLTypes;

public class ReadXMLNode {
  Slide slide;
  List<Slide> slideList = new ArrayList<>();

  // deze bouwt het slide object op
  public List<Slide> readXMLNode(NodeList nodeList) {

    for (int i = 0; i < nodeList.getLength(); i++) {
      Slide ordinarySlide = new OrdinarySlide();

      Node tempNode = nodeList.item(i);
      System.out.println(tempNode);
      // Ensure that the node is Element node
      if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
	if (tempNode.getNodeName().toLowerCase().equals(XMLTypes.ITEM.toXMLLowerCaseValue())) {
	  ReadXMLNodeItem readXMLNodeItem = new OrdinarySlideReadXMLNodeItem();
	  ordinarySlide.setNaam(null);
	  ordinarySlide.items().add(readXMLNodeItem.SlideNode(tempNode));
	}
	if (tempNode.getNodeName().toLowerCase().equals(XMLTypes.TITLE.toXMLLowerCaseValue())) {
	  ReadXMLNodeItem readXMLNodeItem = new OrdinarySlideReadXMLNodeItem();
	  ordinarySlide.setNaam(null);
	  ordinarySlide.items().add(readXMLNodeItem.SlideNode(tempNode));
	}
	if (tempNode.getNodeName().toLowerCase().equals(XMLTypes.SLIDE.toXMLLowerCaseValue())) {
	  // ReadXMLNodeItem readXMLNodeItem = new OrdinarySlideReadXMLNodeItem();

	  // ordinarySlide.setNaam(null);
	  // ordinarySlide.items().add(readXMLNodeItem.SlideNode(tempNode));
	}

      }

      if (tempNode.hasChildNodes()) {
	// Check if child nodes present.
	readXMLNode(tempNode.getChildNodes());

      }
      ReadXMLNodeItem readXMLNodeItem = new OrdinarySlideReadXMLNodeItem();
      ordinarySlide.items().add(readXMLNodeItem.SlideNode(tempNode));
      // System.out.println(readXMLNodeItem.toString());
      // System.out.println("Node Name :- " + tempNode.getNodeName() + " ENDS");
      if (tempNode.getNodeName().toLowerCase().equals(XMLTypes.SLIDE.toXMLLowerCaseValue())) {
	System.out.println("slidelist size:" + slideList.size());
	slideList.add(ordinarySlide);
	System.out.println(ordinarySlide.getItem(0));
	System.out.println("--");
      }

    }

    return slideList;
  }
}