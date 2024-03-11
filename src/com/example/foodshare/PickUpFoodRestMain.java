package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PickUpFoodRestMain extends Activity {
String rno,fname,quantity,details,pickuplocation,pickupendtime,expiretime,cdate,rname;
SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pick_up_food_rest_main);
		EditText et1=(EditText)findViewById(R.id.editText1);
		EditText et2=(EditText)findViewById(R.id.editText2);
		EditText et3=(EditText)findViewById(R.id.editText3);
		EditText et4=(EditText)findViewById(R.id.editText4);
		EditText et5=(EditText)findViewById(R.id.editText5);
		EditText et6=(EditText)findViewById(R.id.editText6);
		EditText et7=(EditText)findViewById(R.id.editText7);
		EditText et8=(EditText)findViewById(R.id.editText8);
		ImageView iv=(ImageView)findViewById(R.id.imageView1);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(PickUpFoodRestMain.this,ViewMap.class);
				it.putExtra("location", pickuplocation);
				startActivity(it);
			}
		});
		
		
		Intent it=getIntent();
		 fname=it.getStringExtra("fname");
		 db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
			Cursor c=db.rawQuery("select * from addfoodres where fname='"+fname+"'", null);
			try{
			c.moveToFirst();
			if(c!=null){
				do {
					rno=c.getString(0);
					rname=c.getString(1);
					quantity=c.getString(2);
					details=c.getString(3);
					pickuplocation=c.getString(4);
					pickupendtime=c.getString(5);
					expiretime=c.getString(6);
					cdate=c.getString(7);
					rname=c.getString(8);
				
					
				} while (c.moveToNext());
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(), "Food Details not found ", 100).show();
			}
			
			int  resID = getResources().getIdentifier(fname,"raw", getPackageName());  
	            
	            
	            
			
			et1.setText(fname);
			et2.setText(rno);
			et3.setText(quantity);
			et4.setText(details);
			et5.setText(pickuplocation);
			et6.setText(pickupendtime);
			et7.setText(expiretime);
			et8.setText(cdate);
			iv.setImageResource(resID);
			 try{
		            db=openOrCreateDatabase("foodconservation",MODE_PRIVATE,null);
		            db.execSQL("create table if not exists orgfoodinfo(uname varchar,fname varchar,quantity varchar,details varchar,pickuplocation varchar,pickupendtime varchar,expirationtime varchar,cdate varchar)");
		            db.execSQL("insert into orgfoodinfo values('"+rname+"','"+fname+"','"+quantity+"','"+details+"','"+pickuplocation+"','"+pickupendtime+"','"+expiretime+"','"+cdate+"')");
		            Toast.makeText(getApplicationContext(),"Food added Successfully",Toast.LENGTH_LONG).show();
		            }catch (Exception e) {
						// TODO: handle exception
		            	Toast.makeText(getApplicationContext(),"Food not added ",Toast.LENGTH_LONG).show();
					}
		            }
			
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pick_up_food_rest_main, menu);
		return true;
	}

}
