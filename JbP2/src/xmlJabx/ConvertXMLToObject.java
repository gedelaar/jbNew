package xmlJabx;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import presentation.SlideShow;

public class ConvertXMLToObject {

  public static void main(String[] args) {

    try {

      File file = new File("test.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(SlideShow.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      SlideShow slideShow = (SlideShow) jaxbUnmarshaller.unmarshal(file);
      System.out.println(slideShow);

    }
    catch (JAXBException e) {
      e.printStackTrace();
    }

  }
}
