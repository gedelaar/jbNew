package test;

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
    String naam = "test";
    String subNaam = "test2";
    Slide slide = new TitleSlide();
    slide.setNaam(naam);
    slide.setSubNaam(subNaam);
    Slide slideReturn = titleSlideFactory.createSlide(slide);
    assertEquals(naam, titleSlideFactory.getSlide().getNaam(), "gelijk");
    assertEquals(subNaam, titleSlideFactory.getSlide().getSubNaam(), "gelijk");

  }

  @Test
  void testGetSlide() {
    String naam = "test";
    String subNaam = "test2";
    TitleSlide slide = new TitleSlide();
    slide.setNaam(naam);
    slide.setSubNaam(subNaam);
    titleSlideFactory.createSlide(slide);
    assertEquals(naam, titleSlideFactory.getSlide().getNaam(), "gelijk");
  }

}
