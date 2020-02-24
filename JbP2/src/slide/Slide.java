package slide;

import java.util.List;

import item.Item;

public abstract class Slide {

	public abstract String getNaam();

	public abstract String setNaam(String naam);

	public abstract String setSubNaam(String subNaam);

	public abstract String getSubNaam();

	public abstract List<Item> items();

	public abstract Item getItem(int index);

}
