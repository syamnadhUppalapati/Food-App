package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UserHome extends Activity {
String uname,phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_home);
		Button bt1=(Button)findViewById(R.id.button1);
		Button bt2=(Button)findViewById(R.id.button2);
		Button bt3=(Button)findViewById(R.id.button3);
		Button bt4=(Button)findViewById(R.id.button4);
		Button bt5=(Button)findViewById(R.id.button5);
		Button bt6=(Button)findViewById(R.id.button6);
		Intent it=getIntent();
		uname=it.getStringExtra("uname");
	    phone=it.getStringExtra("phone");
		
		
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UserHome.this,UserProfile.class);
				it.putExtra("phone", phone);
				startActivity(it);
				
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UserHome.this,NewsFeed.class);
				startActivity(it);
			}
		});
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UserHome.this, ViewHistoryUser.class);
				it.putExtra("uname", uname);
				it.putExtra("phone", phone);
				startActivity(it);
			}
		});
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UserHome.this,FoodAvailabilityUser.class);
				it.putExtra("uname", uname);
				it.putExtra("phone", phone);
				startActivity(it);
				
			}
		});
		bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UserHome.this,RankList.class);
				startActivity(it);
				
			}
		});
		bt6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UserHome.this,Register.class);
				startActivity(it);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_user_home, menu);
		return true;
	}

}
