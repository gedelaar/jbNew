package demo;

import java.util.ArrayList;
import java.util.List;

import item.Item;
import itemAttribute.AttributeAdapter;
import itemAttribute.AttributeKeyKind;
import itemAttribute.AttributeKeyLevel;
import itemAttribute.Line;
import slideshow.SlideShow;
import xml.XmlItem;
import xml.XmlItemAttribute;
import xml.XmlSlideHandler;

/**
 * Een ingebouwde demo-presentatie
 * 
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2020/03/01 Gerard Edelaar
 */

public class DemoPresentation {

	private XmlItemAttribute xmlItemAttribute = new XmlItemAttribute();
	private XmlItem xmlItem;
	private boolean isFirstSlide = true;
	private SlideShow slideShow = new SlideShow();
	private List<Item> items = new ArrayList<>();
	private List<AttributeAdapter> attributes;

	public SlideShow loadFile() {

		xmlItem = new XmlItem();
		slideShow.setShowTitle("Demo Presentation");

		items.add(createItem("title", "JabberPoint", null, null));
		items.add(createItem("item", "Het Java Presentatie Tool", "text", "1"));
		items.add(createItem("item", "Copyright (c) 1996-2000: Ian Darwin", "text", "2"));
		items.add(createItem("item", "Copyright (c) 2000-now:", "text", "2"));
		items.add(createItem("item", "Gert Florijn en Sylvia Stuurman", "text", "2"));
		items.add(createItem("item", "JabberPoint aanroepen zonder bestandsnaam", "text", "4"));
		items.add(createItem("item", "laat deze presentatie zien", "text", "4"));
		items.add(createItem("item", "Navigeren:", "text", "1"));
		items.add(createItem("item", "Volgende slide: PgDn of Enter", "text", "3"));
		items.add(createItem("item", "Vorige slide: PgUp of up-arrow", "text", "3"));
		items.add(createItem("item", "Stoppen: q or Q", "text", "3"));
		items = createSlide(items);

		// next slide
		items.add(createItem("title", "Demonstratie van levels en stijlen", null, null));
		items.add(createItem("item", "Level 1", "text", "1"));
		items.add(createItem("item", "Level 2", "text", "2"));
		items.add(createItem("item", "Nogmaals level 1", "text", "1"));
		items.add(createItem("item", "Level 1 heeft stijl nummer 1", "text", "1"));
		items.add(createItem("item", "Level 2 heeft stijl nummer 2", "text", "2"));
		items.add(createItem("item", "Zo ziet level 3 er uit", "text", "3"));
		items.add(createItem("item", "En dit is level 4", "text", "4"));
		items = createSlide(items);

		// next slide
		items.add(createItem("title", "De derde slide", null, null));
		items.add(createItem("item", "Om een nieuwe presentatie te openen,", "text", "1"));
		items.add(createItem("item", "gebruik File->Open uit het menu.", "text", "2"));
		items.add(createItem("item", " ", "text", "1"));
		items.add(createItem("item", "Dit is het einde van de presentatie.", "text", "1"));
		items.add(createItem("item", "JabberPoint.jpg", "image", "1"));
		items = createSlide(items);

		return slideShow;
	}

	private List<AttributeAdapter> setAttributes(String kind, String level) {
		AttributeKeyKind attrKind = new AttributeKeyKind(kind);
		AttributeKeyLevel attrLevel = new AttributeKeyLevel(level);
		attributes = new ArrayList<>();
		attributes.add(attrKind);
		attributes.add(attrLevel);
		return attributes;
	}

	private Item createItem(String node, String strline, String kind, String level) {
		Line line = new Line(strline);
		if (null != kind || null != level) {
			List<AttributeAdapter> attributes = setAttributes(kind, level);
			return xmlItem.setItemValues(node, line, attributes);
		}
		return xmlItem.setItemValues(node, line, null);

	}

	private List<Item> createSlide(List<Item> items) {
		slideShow.slideAbstractFactories().add((new XmlSlideHandler()).handleSlide(items, isFirstSlide));
		isFirstSlide = false;
		return new ArrayList<>();
	}
}
