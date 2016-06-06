package com.tmm.android.rssreader;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class RssActivity extends Activity {

	
	Button readbutton;
	String source;
	Intent loadit;
	RadioGroup newstype;
	RadioButton sports;
	RadioButton health;
	RadioButton politics;
	RadioButton entertainmnet;
	RadioButton business;
	RadioButton computer;
	String tag = "debug";
	TextView whatnews;
	
	
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		newstype = (RadioGroup) findViewById(R.id.radioGroup1);
		whatnews = (TextView) findViewById(R.id.textView1);
		sports = (RadioButton) findViewById(R.id.radiosports);
		health = (RadioButton) findViewById(R.id.radiohealth);
		business = (RadioButton) findViewById(R.id.radioBusiness);
		politics = (RadioButton) findViewById(R.id.radiopolitics);
		computer = (RadioButton) findViewById(R.id.radiocomputer);
		entertainmnet = (RadioButton) findViewById(R.id.radioEntertainment);
		source = "http://news.google.com/news?ned=us&topic=e&output=rss";
		whatnews.setTextColor(Color.BLUE);		
		newstype.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {				
				
				Log.d(tag, "entered the on changed");								
				
				if (sports.isChecked()) {		
					Log.d(tag, "sports is checked? :" + sports.isChecked());
					Toast.makeText(getApplicationContext(), "sports is selected", Toast.LENGTH_LONG).show();
					source = "http://news.google.com/news?ned=us&topic=s&output=rss";
				}
				if (politics.isChecked()) {
					Log.d(tag, "politics is checked? :" + politics.isChecked());
					Toast.makeText(getApplicationContext(), "politics is selected", Toast.LENGTH_LONG).show();
					source = "http://news.google.com/news?ned=us&topic=w&output=rss";
				}
				if (entertainmnet.isChecked()) {
					Log.d(tag, "Entertein is checked? :" + entertainmnet.isChecked());
					Toast.makeText(getApplicationContext(), "Enterteinment is selected", Toast.LENGTH_LONG).show();
					source = "http://news.google.com/news?ned=us&topic=e&output=rss";
				}
				if (business.isChecked()) {
					Log.d(tag, "business is checked? :" + business.isChecked());
					Toast.makeText(getApplicationContext(), "Business is selected", Toast.LENGTH_LONG).show();
					source = "http://news.google.com/news?ned=us&topic=b&output=rss";
				}
				if (computer.isChecked()) {
					Log.d(tag, "sporcomputer/IT  is checked? :" + computer.isChecked());
					Toast.makeText(getApplicationContext(), "Computer is selected", Toast.LENGTH_LONG).show();
					source = "http://news.google.com/news?ned=us&topic=t&output=rss";
				}
				if (health.isChecked()) {
					Log.d(tag, "Health is checked? :" + health.isChecked());
					Toast.makeText(getApplicationContext(), "Health is selected", Toast.LENGTH_LONG).show();
					source = "http://news.google.com/news?ned=us&topic=m&output=rss";
				}				
			}  // End of onCheckedchange
		});
		
		
		readbutton = (Button) findViewById(R.id.button1);
		readbutton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				loadit = new Intent("com.tmm.android.rssreader.Activity2");
				loadit.putExtra("source", source);				
				startActivity(loadit);
			}
		});					
				
			
		} // End On create
		
		
		

}