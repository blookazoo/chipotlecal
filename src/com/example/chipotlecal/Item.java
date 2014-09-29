package com.example.chipotlecal;

public class Item {
	private String name;
	private int cal;
	private boolean checked = false;
	int imgThumbnail;
	public Item(String name, int cal, int imgThumbnail) {
		this.name = name;
		this.cal = cal;
		this.imgThumbnail = imgThumbnail;
	}
	// returns whether item is checked
	public boolean isChecked() {
		return checked;
	}
	// returns the name
	public String getName() {
		return name;
	}
	// sets the item checkbox
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	// returns calories of the item
	public int getCal() {
		return cal;
	}
	
	// returns the image id
	public int getImg() {
		return imgThumbnail;
	}
	
}
