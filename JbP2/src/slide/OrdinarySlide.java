package slide;

import java.util.ArrayList;
import java.util.List;
import item.Item;

public class OrdinarySlide implements Slide {

	private String naam;
	private List<Item> items = new ArrayList<>();

	public OrdinarySlide(String naam) {
		super();
		this.naam = naam;
	}

	public OrdinarySlide() {
		super();
	}

	public String getNaam() {
		// TODO Auto-generated method stub
		return naam;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrdinarySlide [naam=");
		builder.append(naam);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

	public List<Item> items() {
		// TODO Auto-generated method stub
		return items;
	}

	
}
