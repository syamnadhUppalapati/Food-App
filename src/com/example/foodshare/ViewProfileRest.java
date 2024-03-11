package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class ViewProfileRest extends Activity {
SQLiteDatabase db;
String rname,regno,rtype,adr,phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_profile_rest);
		EditText et1=(EditText)findViewById(R.id.editText1);
		EditText et2=(EditText)findViewById(R.id.editText2);
		EditText et3=(EditText)findViewById(R.id.editText3);
		EditText et4=(EditText)findViewById(R.id.editText4);
		EditText et5=(EditText)findViewById(R.id.editText5);
		
		Intent it=getIntent();
		String rno=it.getStringExtra("rno");
		db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
		Cursor c=db.rawQuery("select * from restarentreg where rno='"+rno+"'", null);
		try{
		c.moveToFirst();
		if(c!=null){
			do {
				rname=c.getString(0);
				regno=c.getString(1);
				rtype=c.getString(2);
				adr=c.getString(3);
				phone=c.getString(4);
				
			} while (c.moveToNext());
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(getApplicationContext(), "Details not found ", 100).show();
		}
		et1.setText(rname);
		et2.setText(rno);
		et3.setText(rtype);
		et4.setText(adr);
		et5.setText(phone);
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_profile_rest, menu);
		return true;
	}

}
