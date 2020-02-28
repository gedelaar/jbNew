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
    String line = "testline";
    Item item = new TextItem(line);
    for (int i = 0; i <= 1; i++) {
      titleSlide.items().add(item);
    }
    assertEquals(line, titleSlide.items().get(0).getLine(), "gelijk");
  }

  @Test
  void testTitleSlideSlide() {
    Slide slide = new TitleSlide();
    slide.setNaam(naam);
    slide.setSubNaam(subNaam);
    Slide slideNew = new TitleSlide(slide);
    // System.out.println(slideNew);
    assertEquals("TitleSlide [subNaam=testSubNaam, naam=test, text=[]]", slideNew.toString());
  }

}
