package slide;

import java.util.ArrayList;
import java.util.List;
import item.Item;

public class OrdinarySlide extends Slide {

  private String naam;
  private String subNaam;
  private List<Item> items = new ArrayList<>();

  public OrdinarySlide(String naam) {
    super();
    this.naam = naam;
  }

  public OrdinarySlide() {
    super();
  }

  public String getNaam() {
    return naam;
  }

  public String setNaam(String naam) {
    return this.naam = naam;
  }

  public List<Item> items() {
    return items;
  }

  @Override
  public void setSubNaam(String subNaam) {
      }

  @Override
  public String getSubNaam() {
    return null;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("OrdinarySlide [naam=");
    builder.append(naam);
    builder.append(", subNaam=");
    builder.append(subNaam);
    builder.append(", items=");
    builder.append(items);
    builder.append("]");
    return builder.toString();
  }

}
