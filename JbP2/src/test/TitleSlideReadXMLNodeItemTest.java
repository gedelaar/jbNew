package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import xml.ConvertToXmlDocument;
import zz_archive.TitleSlideReadXMLNodeItem;
import zz_archive.XmlElementNodeItem;

class TitleSlideReadXMLNodeItemTest {
	/*
	 * final String xmlStr = "<?xml version=\"1.0\"?>"
	 * +"<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">" + "<presentation>" +
	 * "<showtitle>XML-Based Presentation for Jabberpoint</showtitle>" +
	 * "<item>XML-Based Presentation for Jabberpoint2</item>" + "</presentation>";
	 */
	XmlElementNodeItem ti = new TitleSlideReadXMLNodeItem();
	final String xmlStr1 = "title voor showtitle";
	final String xmlStr2 = "XML-Based Presentation for Jabberpoint";

	final String xmlStrShowtitle = "<showtitle>" + xmlStr1 + "</showtitle>";
	final String xmlStrItem = "<item>\" + xmlStr2 + \"</item>";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testTitleSlideNode() throws SAXException, IOException {

		Document doc = ConvertToXmlDocument.convertStringToXMLDocument(xmlStrShowtitle);
		ti.SlideNode(doc.getFirstChild());
		//System.out.println(ti.SlideNode(doc.getChildNodes().item(0)));
		System.out.println(ti.SlideNode(doc).getTextContent());
		Node node = ti.SlideNode(doc.getFirstChild());
		System.out.println("node" + node.getNodeName());
		assertEquals("TitleSlide [subNaam=null, naam=title, text=[Text [line=title voor showtitle]]]", ti.SlideNode(doc.getChildNodes().item(0)));

	}

}
