package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class UserProfile extends Activity {
SQLiteDatabase db;
String uname,adr,phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		EditText et1=(EditText)findViewById(R.id.editText1);
		EditText et2=(EditText)findViewById(R.id.editText2);
		EditText et3=(EditText)findViewById(R.id.editText3);
		Intent it=getIntent();
		String phone=it.getStringExtra("phone");
		
		
		
		db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
		Cursor c=db.rawQuery("select * from userreg where phone='"+phone+"'", null);
		try{
		c.moveToFirst();
		if(c!=null){
			do {
				uname=c.getString(0);
				adr=c.getString(1);
				phone=c.getString(2);
				
				
			} while (c.moveToNext());
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(getApplicationContext(), "Details not found ", 100).show();
		}
		et1.setText(uname);
		et2.setText(adr);
		et3.setText(phone);
		
		}
	



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_user_profile, menu);
		return true;
	}

}
