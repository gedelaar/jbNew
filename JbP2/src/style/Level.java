package style;

import item.Item;

public class Level extends Item {

	String value;

	public Level(String value) {
		super();
		this.value = value;
	}

	@Override
	public String getLine() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void writeLine() {
		// TODO Auto-generated method stub

	}

}
