package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OrgHome extends Activity {
String oname,rno;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_org_home);
		Button bt1=(Button)findViewById(R.id.button1);
		Button bt2=(Button)findViewById(R.id.button2);
		Button bt3=(Button)findViewById(R.id.button3);
		Button bt4=(Button)findViewById(R.id.button4);
		Button bt5=(Button)findViewById(R.id.button5);
		Button bt6=(Button)findViewById(R.id.button6);
		Button bt7=(Button)findViewById(R.id.button7);
		Button bt8=(Button)findViewById(R.id.button8);
		Intent it=getIntent();
		 oname=it.getStringExtra("oname");
		 rno=it.getStringExtra("rno");
		
		
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(OrgHome.this,OrgProfile.class);
				it.putExtra("oname", oname);
				it.putExtra("rno", rno);
				
				startActivity(it);
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(OrgHome.this,NewsFeed.class);
				startActivity(it);
				
			}
		});
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(OrgHome.this,ViewHistoryOrg.class);
				it.putExtra("oname", oname);
				it.putExtra("rno", rno);
				
				startActivity(it);
			}
		});
		
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(OrgHome.this,FoodAvailabilityOrg.class);
				it.putExtra("oname", oname);
				it.putExtra("rno", rno);
				
				startActivity(it);
				
			}
		});
		bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(OrgHome.this,RankList.class);
				startActivity(it);
				
			}
		});
		bt6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(OrgHome.this,Register.class);
				startActivity(it);	
				
			}
		});
		bt7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(OrgHome.this,PickUpFood.class);
				it.putExtra("oname", oname);
				it.putExtra("rno", rno);
				
				startActivity(it);
			}
		});
		bt8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(OrgHome.this,FoodDistribution.class);
				it.putExtra("oname", oname);
				it.putExtra("rno", rno);
				
				startActivity(it);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_org_home, menu);
		return true;
	}

}
