package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import slide.OrdinarySlide;
import xml.ConvertToXmlDocument;
import xml.ReadXMLSlideNode;

class ReadXMLNodeTest {
//@formatter:off
  final String xmlStr = 
        "<?xml version=\"1.0\"?>" 
      + "<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">"
      + "<presentation>" 
      + "     <showtitle>XML-Based Presentation for Jabberpoint</showtitle>" 
      + "     <slide>"
      + "          <title>title for Jabberpoint2</title>" 
      + "          <item>item1 for Jabberpoint2</item>"
      + "          <item kind=\"text\"  level=\"1\">item2 for Jabberpoint3</item>" 
      + "     </slide>" 
      + "</presentation>";
//@formatter:on
  ReadXMLSlideNode node = new ReadXMLSlideNode();

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
  }

  @Test
  void testReadXMLNode() throws SAXException, IOException {
    Document doc = ConvertToXmlDocument.convertStringToXMLDocument(xmlStr);
    OrdinarySlide slide = (OrdinarySlide) node.readXMLSlideNode(doc.getChildNodes());
    assertEquals("gelijk","title for Jabberpoint2", slide.getItems().get(0).getLine());
    assertNotEquals("ongelijk","title for Jabberpoint2", slide.getItems().get(1).getLine());
  }

}
