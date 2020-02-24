package xml;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ConvertToXmlDocument {
	protected static final String FILENAME = "test.xml";

	public static Document convertFileToXMLDocument() throws SAXException, IOException {
		File xmlFile = new File(FILENAME);
		Document document = documentHandler().parse(xmlFile);
		return document;
	}

	public static Document convertStringToXMLDocument(String xmlString) throws SAXException, IOException {
		Document document = documentHandler().parse(new InputSource(new StringReader(xmlString)));
		return document;
	}

	private static DocumentBuilder documentHandler() {
		DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docbuildFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return docBuilder;
	}
}
