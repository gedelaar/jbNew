package item;

public class LevelItem implements Item {

	String value;

	public LevelItem(String value) {
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
