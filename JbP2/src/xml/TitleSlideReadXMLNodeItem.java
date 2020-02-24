package xml;

import org.w3c.dom.Node;

import item.Item;
import item.TextItem;
import slide.Slide;
import slide.TitleSlide;
import slideFactory.SlideAbstractFactory;
import slideFactory.TitleSlideFactory;
import xml.xmlenum.XMLType.XMLTypes;

public class TitleSlideReadXMLNodeItem implements ReadXMLNodeItem {

	@Override
	public Slide SlideNode(Node tempNode) {
		//System.out.println(tempNode);
		SlideAbstractFactory factory = new TitleSlideFactory();

		String naam = XMLTypes.TITLE.toXMLLowerCaseValue();
		TitleSlide titleSlide = new TitleSlide();
		titleSlide.setNaam(naam);
		//System.out.println(tempNode.getTextContent());
		titleSlide.items().add(new TextItem(tempNode.getTextContent()));
		// titleSlide.setSubNaam(subNaam);
		Slide slide = factory.createSlide(titleSlide);

		//System.out.println("\nNode Name =" + tempNode.getNodeName() + " STARTS");
		//System.out.println("Node Value =" + tempNode.getTextContent());

		/*
		 * Item item = new TextItem(tempNode.getTextContent());
		 * 
		 * slide.items().add(item);
		 */

		if (tempNode.hasAttributes()) {
			// get attributes names and values
			XmlNodeAttribute xmlNodeAttribute = new XmlNodeAttribute();
			Item item = xmlNodeAttribute.getXMLAttributes(tempNode);
			//System.out.println(item);
			// NamedNodeMap nodeMap= getXMLAttributes(tempNode);
			slide.items().add(item);
		}
		return titleSlide;
	}

	// komt een regel binnen
	public Item Node(Node tempNode) {
		
		return null;
		
	}
}
