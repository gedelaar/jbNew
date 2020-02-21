package slide;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class TitleSlide implements Slide {
	private String subNaam;
	private String naam;
	private List<Item> text = new ArrayList<>();

	public TitleSlide(String naam, String subNaam) {
		this.naam = naam;
		this.subNaam = subNaam;
	}

	public TitleSlide(String naam) {
		this(naam, null);
	}

	public TitleSlide() {
	}

	@Override
	public String getNaam() {
		// TODO Auto-generated method stub
		return naam;
	}

	public String getSubNaam() {
		return subNaam;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TitleSlide [naam=");
		builder.append(naam);
		builder.append(", subNaam=");
		builder.append(subNaam);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public List<Item> items() {
		// TODO Auto-generated method stub
		return text	;
	}

}
