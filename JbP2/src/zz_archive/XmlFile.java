package zz_archive;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import slide.Slide;
import slideFactory.OrdinarySlideFactory;
import slideFactory.SlideAbstractFactory;
import xml.ConvertToXmlDocument;

// deze bouwt het presentatie object op (dus verzameling slides)
public class XmlFile {

  public List<SlideAbstractFactory> readXML() {
    List<SlideAbstractFactory> slideListAbstractFactory = new ArrayList<>();
    try {
      Document document = ConvertToXmlDocument.convertFileToXMLDocument();

      if (document.hasChildNodes()) {
	System.out.println(getClass()+" => childnodes");
	XmlSlideNode readXMLNode = new XmlSlideNode();
	List<Slide> slideList =  readXMLNode.xmlSlideNode(document.getChildNodes());

	//*****
	// System.out.println(slideList);
	int i = 0;
	for (Slide slide : slideList) {

	  System.out.println(getClass() + " => " + slide);

	 // if (slide.getClass().getTypeName() == "slide.OrdinarySlide") {
	    SlideAbstractFactory slideAbstractFactory = new OrdinarySlideFactory();
	    slideAbstractFactory.createSlide(slide);
	    // System.out.println("slide items" + slide.items());
	    // slideListAbstractFactory.add(new OrdinarySlideFactory());
	    slideListAbstractFactory.add(slideAbstractFactory);
	    //System.out.println("slideListAbstractFactory1->" + slideListAbstractFactory.get(i).getSlide().getItem(0));
	   // System.out.println("slideListAbstractFactory2->"
	//	+ slideListAbstractFactory.get(i).getSlide().getItem(0).getItemAttribute(0));
	   // i++;
	 // }
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
