package item.type;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import item.ImageItem;
import item.Item;
import item.TextItem;

public class TypeClass implements KeyProcessor {
	private static final String TEXT = "TEXT";
	private static final String IMAGE = "IMAGE";
	public Map<String, KeyProcessor> d = new HashMap<>();

	public TypeClass() {
		d.put(TEXT, (KeyProcessor) new TypeText());
		d.put(IMAGE, (KeyProcessor) new TypeImage());
	}

	public class TypeText implements KeyProcessor {
		protected static final String TEXT = "TEXT";

		@Override
		public Item getType() {
			return new TextItem();
		}

		@Override
		public String getTypeValue() {
			return TEXT;
		}

	}

	public class TypeImage implements KeyProcessor {
		protected static final String IMAGE = "IMAGE";

		@Override
		public Item getType() {
			return new ImageItem();
		}

		@Override
		public String getTypeValue() {
			return IMAGE;
		}
	}

//Get a set of the entries
	// Set set = d.entrySet();

	@Override
	public Item getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeValue() {
		// TODO Auto-generated method stub
		return null;
	}

}