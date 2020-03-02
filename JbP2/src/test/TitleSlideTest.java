package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import item.Item;
import item.TextItem;
import slide.TitleSlide;

class TitleSlideTest {
  TitleSlide titleSlide = new TitleSlide();
  public String naam = getClass() + " naam";
  public String subNaam = getClass() + " subNaam";

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
    assertEquals(naam, titleSlide.getNaam());
  }

  @Test
  void testGetSubNaam() {
    assertNull(titleSlide.getSubNaam());
    titleSlide.setSubNaam(subNaam);
    assertEquals(subNaam, titleSlide.getSubNaam());
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

}
