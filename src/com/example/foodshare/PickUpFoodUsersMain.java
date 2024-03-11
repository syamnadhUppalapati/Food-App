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

public class PickUpFoodUsersMain extends Activity {
	String uname,fname,quantity,details,pickuplocation,pickupendtime,expiretime,cdate,phone;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pick_up_food_users_main);
		
		
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
		Intent it=getIntent();
		 
		 fname=it.getStringExtra("fname");
		
			bt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent it1=new Intent(PickUpFoodUsersMain.this,ViewMap.class);
					it1.putExtra("location", pickuplocation);
					startActivity(it1);
				}
			});
		 
		 db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
			Cursor c=db.rawQuery("select * from addfooduser where fname='"+fname+"'", null);
			try{
			c.moveToFirst();
			if(c!=null){
				do {
					uname=c.getString(0);
					phone=c.getString(1);
					quantity=c.getString(3);
					details=c.getString(4);
					pickuplocation=c.getString(5);
					pickupendtime=c.getString(6);
					expiretime=c.getString(7);
					cdate=c.getString(8);
				
					
				} while (c.moveToNext());
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(), "Food Details not found ", 100).show();
			}
			
			int  resID = getResources().getIdentifier(fname,"raw", getPackageName());  
	            
	            
	            
			
			et1.setText(fname);
			et2.setText(phone);
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
		            db.execSQL("insert into orgfoodinfo values('"+uname+"','"+fname+"','"+quantity+"','"+details+"','"+pickuplocation+"','"+pickupendtime+"','"+expiretime+"','"+cdate+"')");
		            Toast.makeText(getApplicationContext(),"Food added Successfully",Toast.LENGTH_LONG).show();
		            }catch (Exception e) {
						// TODO: handle exception
		            	Toast.makeText(getApplicationContext(),"Food not added ",Toast.LENGTH_LONG).show();
					}
		            }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pick_up_food_users_main, menu);
		return true;
	}

}
