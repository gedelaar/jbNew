package slide;

import java.util.List;

import item.Item;

public class SpecialSlide extends Slide {
	private String naam;

	public SpecialSlide(String naam) {
		this.naam = naam;
	}

	@Override
	public String getNaam() {
		// TODO Auto-generated method stub
		return naam;
	}

	@Override
	public List<Item> items() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}
