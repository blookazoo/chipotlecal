package com.example.chipotlecal;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class MainActivity extends ActionBarActivity implements OnItemClickListener {
	ListView lv;
	CustomListViewAdapter adapter;
	List<Item> items = new ArrayList<Item>(); // list of all chipotle items
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// need to set view for id footer
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		lv = (ListView) findViewById(R.id.listView);
		
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.container);
		layout.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView tv = (TextView)findViewById(R.id.main_footer);
				tv.setText("" + adapter.total);
				//Log.w("MainActivity", "onclick");
			}
		});
		
		items = getItems();
		adapter = new CustomListViewAdapter(this, items);
		lv.setAdapter(adapter);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	

	
	// add items to the list, returns an array list of Items
	private List<Item> getItems() {
		items.add(new Item("tortilla", 300, R.drawable.tortilla));
		items.add(new Item("quesadilla", 400, R.drawable.ic_launcher));
		items.add(new Item("white rice", 185, R.drawable.white));
		items.add(new Item("brown rice", 200, R.drawable.brown));
		items.add(new Item("black beans", 120, R.drawable.black));
		items.add(new Item("pinto beans", 115, R.drawable.pinto));
		items.add(new Item("fajita vegetables", 20, R.drawable.fajita));
		items.add(new Item("chicken", 180, R.drawable.chicken));
		items.add(new Item("steak", 190, R.drawable.steak));
		items.add(new Item("sofritas", 145, R.drawable.sofritas));
		items.add(new Item("barbacoa", 165, R.drawable.barbacoa));
		items.add(new Item("carnitas", 220, R.drawable.carnitas));
		items.add(new Item("mild salsa", 20, R.drawable.mild));
		items.add(new Item("medium salsa", 20, R.drawable.medium));
		items.add(new Item("hot salsa", 25, R.drawable.hot));
		items.add(new Item("sour cream", 115, R.drawable.sourcream));
		items.add(new Item("cheese", 100, R.drawable.cheese));
		items.add(new Item("corn salsa", 80, R.drawable.corn));
		items.add(new Item("guacamole", 200, R.drawable.guac));
		items.add(new Item("lettuce", 5, R.drawable.lettuce));

		return items;
	}



	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	
	// updates the total calories as checkboxes get clicked
	public void updateFooter(int total) {
		TextView tv = (TextView)findViewById(R.id.main_footer);
		tv.setText("total calories: " + total);
	}





}
