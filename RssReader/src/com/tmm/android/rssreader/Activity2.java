package com.tmm.android.rssreader;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;

import com.tmm.android.rssreader.reader.RssReader;

public class Activity2 extends Activity{
	private RssListAdapter adapter;
	List<JSONObject> jobs = new ArrayList<JSONObject>();
	ListView mylist;
	String feed;
	Bundle data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity2);
		data = getIntent().getExtras();
		feed = data.getString("source");
		Log.d("tag", feed);
		mylist = (ListView) findViewById(R.id.listView1);
		try {
			jobs = RssReader.getLatestRssFeed(feed);
			adapter = new RssListAdapter(this,jobs);
			
		} catch (Exception e) {
			Log.e("RSS ERROR", "Error loading RSS Feed Stream >> " + e.getMessage() + " //" + e.toString());
		} 
		mylist.setAdapter(adapter);
		
		
	}  // End of onCreate

}
