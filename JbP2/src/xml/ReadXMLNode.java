package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import slide.OrdinarySlide;
import slide.Slide;
import xml.xmlenum.XMLType.XMLTypes;

//bouwt de overige nodes op
public class ReadXMLNode {
  Slide slide;
  List<Slide> slideList = new ArrayList<>();

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
      }

      if (tempNode.hasChildNodes()) {
	// Check if child nodes present.
	readXMLNode(tempNode.getChildNodes());
      }
    }
    return slideList;
  }

}
