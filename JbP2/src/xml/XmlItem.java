package xml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;

import item.ImageItem;
import item.Item;
import item.TextItem;
import item.type.EnumAttributeValue.XMLAttributeValues;
import item.type.KeyProcessor;
import item.type.TypeClass;

import itemAttribute.AttributeAdapter;
import itemAttribute.Line;

public class XmlItem {

	public Item itemValueXMLWrapper(Node node) {
		String naam = node.getNodeName();
		Line line = new Line(node.getTextContent());

		//List<AttributeAdapter> attributes = new ArrayList<>();
		List<AttributeAdapter> attributes = null;
		XmlItemAttribute xmlItemAttribute = new XmlItemAttribute();
		Item item = null;

		if (node.hasAttributes()) {
			attributes = xmlItemAttribute.AttributeXMLWrapper(node);
			item = getItemType(attributes);
		}

		item = setItemValues(naam, line, attributes);
		return item;

	}

	public Item setItemValues(String naam, Line line, List<AttributeAdapter> attributes) {
		Item item = null;
		List<AttributeAdapter> listAttributes = new ArrayList<>();
		listAttributes = attributes;

		if (null != attributes && attributes.size()>0) {
			item = getItemType(attributes);
			try {
				item.itemAttributes().addAll(listAttributes);
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.out.println(getClass()+" " + item.getLine().getLine());
			}
		}

		if (null == item) {
			item = new TextItem();
		}
		item.setNaam(naam);
		item.setLine(line);
		return item;
	}

	private Item getItemType(List<AttributeAdapter> attributes) {
		for (int i = 0; i < attributes.size(); i++) {

			TypeClass typeClass = new TypeClass();
			XMLAttributeValues attrValue = XMLAttributeValues.valueOf(attributes.get(i).getValue().toUpperCase());
			for (Map.Entry entry : typeClass.d.entrySet()) {
				KeyProcessor keyProcessor = typeClass.d.get(entry.getKey());
				if (keyProcessor == null) {
					throw new IllegalStateException("Unknown processor for key " + entry.getKey());
				}
				if (attrValue.name() == keyProcessor.getTypeValue()) {
					return keyProcessor.getType();
				}
			}
		}
		return null;
	}
}
