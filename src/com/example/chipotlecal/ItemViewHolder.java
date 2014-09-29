package com.example.chipotlecal;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemViewHolder {
	private CheckBox checkBox;
	private TextView textView;
	private ImageView imageView;
	public ItemViewHolder(TextView textView, CheckBox checkBox, ImageView imageView ) {
		this.checkBox = checkBox;
		this.textView = textView;
		this.imageView = imageView;
	}
	
	public void setCheckBox(CheckBox checkBox) {
		this.checkBox = checkBox;
	}
	
	public CheckBox getCheckBox() {
		return checkBox;
	}
	
	public TextView getTextView() {
		return textView;
	}
	
	public void setTextView(TextView textView) {
		this.textView = textView;
	}
	
	public ImageView getImageView() {
		return imageView;
	}
	
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
}
