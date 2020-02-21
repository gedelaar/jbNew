package item;

public class TextItem implements Item {
	String line;

	public TextItem(String line) {
		super();
		this.line = line;
	}

	@Override
	public void getLine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeLine() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Text [line=");
		builder.append(line);
		builder.append("]");
		return builder.toString();
	}

}
