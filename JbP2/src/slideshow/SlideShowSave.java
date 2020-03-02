package slideshow;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;

import item.Attribute;
import item.Item;
import slideFactory.SlideAbstractFactory;

public class SlideShowSave {

  public void saveSlideShow(SlideShow slideShow) throws ParserConfigurationException {

    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

    // root elements
    Document doc = docBuilder.newDocument();
    Element rootElement = doc.createElement("presentation");
    doc.appendChild(rootElement);

    // presentation elements
    Element showTitle = (Element) doc.createElement("showtitle");
    rootElement.appendChild(showTitle);
    showTitle.appendChild(doc.createTextNode(slideShow.getShowTitle()));

    // slide elements
    for (SlideAbstractFactory slideAbF : slideShow.slideAbstractFactories()) {
      Element slide = doc.createElement("slide");
      rootElement.appendChild(slide);
      slide.appendChild(doc.createTextNode(slideAbF.getSlide().getNaam()));

      // item elements
      for (Item item : slideAbF.getSlide().items()) {
	Element nodeItem = doc.createElement(item.getItemNaam());
	slide.appendChild(nodeItem);
	nodeItem.appendChild(doc.createTextNode(item.getLine()));

	if (null != item.itemAttributes()) {
	  for (Attribute attribute : item.itemAttributes()) {
	    Attr attr = doc.createAttribute(attribute.getNaam());
	    attr.setValue(attribute.getValue());
	    nodeItem.setAttributeNode(attr);
	  }
	}
      }
    }

    Transformer transformer;
    try {
      transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      DOMSource source = new DOMSource(doc);
      StreamResult console = new StreamResult(System.out);
      try {
	transformer.transform(source, console);
      }
      catch (TransformerException e) {
	e.printStackTrace();
      }
    }
    catch (TransformerConfigurationException e) {
      e.printStackTrace();
    }
    catch (TransformerFactoryConfigurationError e) {
      e.printStackTrace();
    }
  }
}