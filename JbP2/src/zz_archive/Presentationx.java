package zz_archive;

public class Presentationx {
	private String showtitle;
	private String slide;
	private String title;
	private String item;
	
	public String getShowtitle() {
		return showtitle;
	}
	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
	}
	public String getSlide() {
		return slide;
	}
	public void setSlide(String slide) {
		this.slide = slide;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Presentation [showtitle=");
		builder.append(showtitle);
		builder.append(", slide=");
		builder.append(slide);
		builder.append(", title=");
		builder.append(title);
		builder.append(", item=");
		builder.append(item);
		builder.append("]");
		return builder.toString();
	}

	
}
