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
	ReadXMLSlideNode readXMLNode = new ReadXMLSlideNode();

	List<Slide> slideList = (List<Slide>) readXMLNode.readXMLSlideNode(document.getChildNodes());
	// System.out.println(slideList);
	int i = 0;
	for (Slide slide : slideList) {

	  if (slide.getClass().getTypeName() == "slide.OrdinarySlide") {
	    SlideAbstractFactory slideAbstractFactory = new OrdinarySlideFactory();
	    slideAbstractFactory.createSlide(slide);
	    // System.out.println("slide items" + slide.items());
	    // slideListAbstractFactory.add(new OrdinarySlideFactory());
	    slideListAbstractFactory.add(slideAbstractFactory);
	    System.out.println("slideListAbstractFactory1->" + slideListAbstractFactory.get(i).getSlide().getItem(0));
	    System.out.println("slideListAbstractFactory2->" + slideListAbstractFactory.get(i).getSlide().getItem(0).getNodeAttributes());
	    i++;
	  }
	}

      }

    }
    catch (Exception e) {
      e.printStackTrace();
    }
    // System.out.println(slideListAbstractFactory);
    return slideListAbstractFactory;
  }

}
