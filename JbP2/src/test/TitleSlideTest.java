package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import item.Item;
import item.TextItem;
import slide.Slide;
import slide.TitleSlide;

class TitleSlideTest {
	TitleSlide titleSlide = new TitleSlide();
	String naam;
	String subNaam;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		naam = "test";
		subNaam = "testSubNaam";

	}

	@Test
	void testGetNaam() {
		assertNull(titleSlide.getNaam());
		titleSlide.setNaam(naam);
		assertEquals("test", titleSlide.getNaam());
	}

	@Test
	void testGetSubNaam() {
		assertNull(titleSlide.getSubNaam());
		titleSlide.setSubNaam(naam);
		assertEquals("test", titleSlide.getSubNaam());
	}

	@Test
	void testItems() {
		Item item = new TextItem("testline");
		//System.out.println(item);
		for (int i = 0; i <= 1; i++) {
			titleSlide.items().add(item);
		}
		//System.out.println(titleSlide.toString());
		assertEquals("TitleSlide [subNaam=null, naam=null, text=[Text [line=testline], Text [line=testline]]]", titleSlide.toString());
	}

	
	@Test
	void testTitleSlideSlide() {
		Slide slide = new TitleSlide();
		slide.setNaam(naam);
		slide.setSubNaam(subNaam);
		Slide slideNew = new TitleSlide(slide);
		//System.out.println(slideNew);
		assertEquals("TitleSlide [subNaam=testSubNaam, naam=test, text=[]]", slideNew.toString());
	}

}
