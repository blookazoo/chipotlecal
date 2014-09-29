package com.example.chipotlecal;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
  
public class CustomListViewAdapter extends ArrayAdapter<Item> {
	
	public int total;
	private LayoutInflater inflater;
	MainActivity activity;
	
	public CustomListViewAdapter(Context context, List<Item> items) {
		super(context, R.layout.singlerow, R.id.rowTextView, items);
		inflater = LayoutInflater.from(context);
		this.activity = (MainActivity)context;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Item item = (Item) this.getItem(position);
		
		CheckBox checkBox;
		TextView textView;
		ImageView imageView;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.singlerow, null);
			
			textView = (TextView) convertView.findViewById(R.id.rowTextView);
			checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
			imageView = (ImageView) convertView.findViewById(R.id.imgThumbnail);
			convertView.setTag( new ItemViewHolder(textView, checkBox, imageView));
			
			
			checkBox.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					CheckBox chb = (CheckBox) v;
					Item item = (Item) chb.getTag();
					item.setChecked(chb.isChecked());
					
					// updates the total calories
					if (chb.isChecked()) {
						total += item.getCal();
					} else {
						total -= item.getCal();
					} 
					//Log.w("CustomListViewAdapter", "in onclick");
					activity.updateFooter(total);
				}
			}); 
		} else {
			ItemViewHolder viewHolder = (ItemViewHolder) convertView.getTag();
			checkBox = viewHolder.getCheckBox();
			textView = viewHolder.getTextView();
			imageView = viewHolder.getImageView();
			
		}
		checkBox.setTag(item);
		
		// displays the row
		checkBox.setChecked(item.isChecked());
		textView.setText(item.getName());
		imageView.setImageResource(item.getImg());

		return convertView;
	}  

    
}

