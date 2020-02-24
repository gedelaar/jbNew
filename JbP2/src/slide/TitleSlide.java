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
	public String getNaam() {
		return naam;
	}

	public String getSubNaam() {
		return subNaam;
	}

	@Override
	public List<Item> items() {
		// TODO Auto-generated method stub
		return items;
	}
	
	

	@Override
	public String setNaam(String naam) {
		// TODO Auto-generated method stub
		return this.naam = naam;
	}

	@Override
	public String setSubNaam(String subNaam) {
		return this.subNaam = subNaam;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TitleSlide [subNaam=");
		builder.append(subNaam);
		builder.append(", naam=");
		builder.append(naam);
		builder.append(", text=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public Item getItem(int index) {
		// TODO Auto-generated method stub
		return items.get(index);
	}

}