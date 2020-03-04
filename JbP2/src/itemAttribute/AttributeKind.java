package itemAttribute;

import java.util.ArrayList;
import java.util.List;
import static itemAttribute.EnumAttributeKey.XMLAttributes.*;
import static itemAttribute.EnumAttributeValue.XMLAttributeValues.*;

public class AttributeKind implements AttributeAdapter {
	private AttributeKey attributeKey;
	private AttributeValue attributeValue = null;
	List<AttributeValue> attributeValues = new ArrayList<>();

	public AttributeKind(String value) {
		attributeKey = new AttributeKey(KIND.toString());
		attributeValues = attributeValue();
		setAttributeValue(value);
	}

	@Override
	public String getKey() {
		return attributeKey.getKey();
	}

	@Override
	public boolean checkValue(String value) {
		// System.out.println(value);
		attributeValue = new AttributeValue(value.toUpperCase());
		
		return (attributeValues.contains(attributeValue.getValue()));
	}

	public List<AttributeValue> attributeValue() {
		attributeValues.add(new AttributeValue(IMAGE.toString()));
		attributeValues.add(new AttributeValue(TEXT.toString()));
		return attributeValues;
	}

	@Override
	public void setAttributeValue(String value) {
		if (checkValue(value)) {
			attributeValue = new AttributeValue(value);
		}
	}

	@Override
	public String getValue() {
		return attributeValue.getValue().toLowerCase();
	}
}
