package xml;

import java.io.File;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import item.Item;
import item.TextItem;
import slide.Slide;
import slideFactory.OrdinarySlideFactory;
import slideFactory.SlideAbstractFactory;
import slideFactory.TitleSlideFactory;

public class ReadXMLByLoopingNode {
	public Set<SlideAbstractFactory> slideList;

	public Set<SlideAbstractFactory> readXML() {
		try {
			File xmlFile = new File(
					"E:\\gerard\\OneDrive\\OU\\master\\design for change (feb 2020)\\Jabberpoint/test.xml");
			DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
			Document document = docBuilder.parse(xmlFile);

			System.out.println("Root element name :- " + document.getDocumentElement().getNodeName());

			if (document.hasChildNodes()) {

				slideList = printNode(document.getChildNodes(), slideList);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return slideList;
	}

	public static Set<SlideAbstractFactory> printNode(NodeList nodeList, Set<SlideAbstractFactory> slideList) {
		// Slide slide = factory.createSlide("Ordinary");
		for (int i = 0; i < nodeList.getLength(); i++) {
			// System.out.println(factory.toString());

			Node tempNode = nodeList.item(i);
			SlideAbstractFactory factory;
			Slide slide;
			if (tempNode.equals("showtitle")) {
				factory = new TitleSlideFactory();
				slide = factory.createSlide("Title");
			} else {
				factory = new OrdinarySlideFactory();
				slide = factory.createSlide("Ordinary");
			}

			// Ensure that the node is Element node
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// print node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " STARTS");
				System.out.println("Node Value =" + tempNode.getTextContent());
				Item item = new TextItem(tempNode.getTextContent());

				slide.items().add(item);
				slideList.add(factory);
				// System.out.println(factory.getSlide().toString());

				// Check if attributes present in this node
				if (tempNode.hasAttributes()) {

					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int j = 0; j < nodeMap.getLength(); j++) {

						Node node = nodeMap.item(j);
						System.out.println("Attribute Name : " + node.getNodeName());
						System.out.println("Attribute Value : " + node.getNodeValue());

					}

				}

				if (tempNode.hasChildNodes()) {

					// Check if child nodes present.
					printNode(tempNode.getChildNodes(), slideList);

				}

				System.out.println("Node Name :- " + tempNode.getNodeName() + " ENDS");

			}

		}
		return slideList;
	}
}