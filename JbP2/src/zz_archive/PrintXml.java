package zz_archive;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

 public  class  PrintXml {

  public void transForm(NodeList nodeList) throws TransformerException, ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse((InputStream) nodeList);
    
    Transformer tform = TransformerFactory.newInstance().newTransformer();
    tform.setOutputProperty(OutputKeys.INDENT, "yes");
    tform.setOutputProperty(document.getTextContent(), "2");
    tform.transform(new DOMSource(document), new StreamResult(System.out));
  }
}
