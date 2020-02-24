package xml;

import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import slide.Slide;
import slideFactory.SlideAbstractFactory;
import xml.xmlenum.XMLType.XMLTypes;

public class ReadXMLByLoopingNodeData {

	public  List<SlideAbstractFactory> explodeNode(NodeList nodeList, List<SlideAbstractFactory> slideList) {
		SlideAbstractFactory factory;
		//Slide slide;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node tempNode = nodeList.item(i);
			// Ensure that the node is Element node
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				if (tempNode.getNodeName().toLowerCase().equals(XMLTypes.SHOWTITLE.toXMLLowerCaseValue())) {
					ElementNode elementNode = new TitleSlideReadXMLNodeItem();
					factory = (SlideAbstractFactory) elementNode.factory(tempNode);
				} else {
					ElementNode elementNode = new OrdinarySlideReadXMLNodeItem();
					factory = (SlideAbstractFactory) elementNode.factory(tempNode);
				}
				slideList.add(factory);
			}

			if (tempNode.hasChildNodes()) {

				// Check if child nodes present.
				readXMLNode(tempNode.getChildNodes(), slideList);

			}

			System.out.println("Node Name :- " + tempNode.getNodeName() + " ENDS");

		}

		return slideList;
	}
}