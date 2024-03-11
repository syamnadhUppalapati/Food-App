package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RestHome extends Activity {
String rname,rno;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rest_home);
		Button bt1=(Button)findViewById(R.id.button1);
		Button bt2=(Button)findViewById(R.id.button2);
		Button bt3=(Button)findViewById(R.id.button3);
		Button bt4=(Button)findViewById(R.id.button4);
		Button bt5=(Button)findViewById(R.id.button5);
		Button bt6=(Button)findViewById(R.id.button6);
		Intent it=getIntent();
		 rname=it.getStringExtra("rname");
		 rno=it.getStringExtra("rno");
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(RestHome.this,ViewProfileRest.class);
				it.putExtra("rno", rno);
				startActivity(it);
				
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(RestHome.this,NewsFeed.class);
				startActivity(it);
				
			}
		});
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(RestHome.this,ViewHistoryRest.class);
				it.putExtra("rno", rno);
				startActivity(it);
				
			}
		});
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(RestHome.this,FoodAvailabilityRest.class);
				it.putExtra("rno", rno);
				it.putExtra("rname", rname);
				startActivity(it);
				
			}
		});
		bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(RestHome.this,RankList.class);
				startActivity(it);
				
			}
		});
		bt6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(RestHome.this,Register.class);
				startActivity(it);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_rest_home, menu);
		return true;
	}

}
