package xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import slide.Slide;
import slideFactory.OrdinarySlideFactory;
import slideFactory.SlideAbstractFactory;

// deze bouwt het presentatie object op (dus verzameling slides)
public class ReadXMLFile {
  private List<SlideAbstractFactory> slideListAbstractFactory = new ArrayList<>();

  public List<SlideAbstractFactory> readXML() {
    try {
      Document document = ConvertToXmlDocument.convertFileToXMLDocument();

      if (document.hasChildNodes()) {
	ReadXMLNode readXMLNode = new ReadXMLNode();

	List<Slide> slideList = (List<Slide>) readXMLNode.readXMLNode(document.getChildNodes());
	//System.out.println(slideList);
	for (Slide slide : slideList) {
	  if (slide.getClass().getTypeName() == "slide.OrdinarySlide") {
	    SlideAbstractFactory slideAbstractFactory = new OrdinarySlideFactory();
	    slideAbstractFactory.createSlide(slide);
	    slideListAbstractFactory.add(new OrdinarySlideFactory());
	  }
	}
	

      }

    }
    catch (Exception e) {
      e.printStackTrace();
    }
    //System.out.println(slideListAbstractFactory);
    return slideListAbstractFactory;
  }

}
