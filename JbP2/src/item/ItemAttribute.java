package item;

public class ItemAttribute implements Attribute {
  private String naam;
  private String value;

  public String getNaam() {
    return naam;
  }

  public void setNaam(String naam) {
    this.naam = naam;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ItemAttribute [naam=");
    builder.append(naam);
    builder.append(", value=");
    builder.append(value);
    builder.append("]");
    return builder.toString();
  }

}
