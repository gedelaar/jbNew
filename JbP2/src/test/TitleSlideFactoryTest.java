package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import slide.Slide;
import slide.TitleSlide;
import slideFactory.TitleSlideFactory;
 

class TitleSlideFactoryTest {
	TitleSlideFactory titleSlideFactory = new TitleSlideFactory();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCreateSlide() {
		Slide slide = new TitleSlide();
		slide.setNaam("test");
		slide.setSubNaam("test2");
		Slide slideReturn = titleSlideFactory.createSlide(slide);
		//System.out.println(this.getClass());
		//System.out.println(slideReturn);
		assertEquals("TitleSlide [naam=test, subNaam=test2]", slideReturn.toString(),"gelijk");
		
	}

	@Test
	void testGetSlide() {
		TitleSlide slide = new TitleSlide();
		slide.setNaam("test");
		slide.setSubNaam("test2");
		titleSlideFactory.createSlide(slide);
		//System.out.println(titleSlideFactory.getSlide());
		assertEquals("test", titleSlideFactory.getSlide().getNaam(),"gelijk");
	}

}
