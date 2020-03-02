package slide;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class TitleSlide extends Slide {

  private String subNaam;
  private String naam;
  private List<Item> items = new ArrayList<>();

  public TitleSlide() {
  }

  public TitleSlide(Slide slide) {
    this.naam = slide.getNaam();
    this.subNaam = slide.getSubNaam();
  }

  @Override
  public String setNaam(String naam) {
    return this.naam = naam;
  }

  @Override
  public String getNaam() {
    return naam;
  }

  @Override
  public void setSubNaam(String subNaam) {
    this.subNaam = subNaam;
  }

  public String getSubNaam() {
    return subNaam;
  }

  @Override
  public List<Item> items() {
    return items;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("TitleSlide [subNaam=");
    builder.append(subNaam);
    builder.append(", naam=");
    builder.append(naam);
    builder.append(", items=");
    builder.append(items);
    builder.append("]");
    return builder.toString();
  }

}