package slideFactory;

import java.util.ArrayList;
import java.util.List;

import item.Item;
import slide.Slide;
import slide.SpecialSlide;

public class SpecialSlideFactory implements SlideAbstractFactory {

	private String naam;
	private List<Item> items = new ArrayList<>();
	
	@Override
	public Slide createSlide(String naam) {
		return new SpecialSlide(naam);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpecialSlideFactory [naam=");
		builder.append(naam);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public Slide getSlide() {
		// TODO Auto-generated method stub
		return null;
	}

}
