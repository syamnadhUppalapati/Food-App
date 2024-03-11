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
import android.widget.Toast;

public class CheckOtp extends Activity {
	SQLiteDatabase db;
String phone,otp1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_otp);
		final EditText et1=(EditText)findViewById(R.id.editText1);
		Button bt=(Button)findViewById(R.id.button1);
		Intent it=getIntent();
		 phone=it.getStringExtra("phone");
		 otp1=it.getStringExtra("otp");
		 bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String otp=et1.getText().toString();
				if(otp.equals(otp1)){
					try{
						db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
						Cursor c=db.rawQuery("select * from checkotp where phone='"+phone+"' and otp='"+otp1+"'", null);
						c.moveToFirst();
						if(c!=null){
							do {
								Toast.makeText(getApplicationContext(), "Verified details Successfully", Toast.LENGTH_LONG).show();
								Intent it=new Intent(CheckOtp.this,Register.class);
								startActivity(it);
							} while (c.moveToNext());
						}}catch (Exception e) {
							// TODO: handle exception
							Toast.makeText(getApplicationContext(), "Invalid OTP", Toast.LENGTH_LONG).show();
						}}else{
							Toast.makeText(getApplicationContext(), "Please enter valid  OTP", Toast.LENGTH_LONG).show();
						}
					}
					
				
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_check_otp, menu);
		return true;
	}

}
