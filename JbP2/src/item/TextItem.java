package item;

import java.util.List;

public class TextItem implements Item {
	String line;
	String naam;
	List<NodeAttribute> nodeAttribute;

	public TextItem(String line) {
		super();
		this.line = line;
	}

	@Override
	public String getLine() {
		return line;
		// TODO Auto-generated method stub

	}

	@Override
	public void writeLine() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextItem [line=");
		builder.append(line);
		builder.append(", naam=");
		builder.append(naam);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void node() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public String setNodeNaam(String naam) {
		this.naam = naam;
		return null;
	}

	@Override
	public String getNodeNaam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodeAttribute getNodeAttribute(int index) {
	  // TODO Auto-generated method stub
	  return nodeAttribute.get(index);
	}


	public void setNodeAttribute(List<NodeAttribute> nodeAttribute) {
	  this.nodeAttribute = nodeAttribute;
	}

}
