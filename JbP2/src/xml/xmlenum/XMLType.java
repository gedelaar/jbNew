package xml.xmlenum;

public class XMLType {
	public enum XMLTypes {
		PRESENTATION, SHOWTITLE, SLIDE, TITLE, ITEM;

		public String toXMLLowerCaseValue() {
			return this.name().toLowerCase();
		}

		public static XMLTypes from(String status) {
			return XMLTypes.valueOf(status.toUpperCase());
		}

	}
}
