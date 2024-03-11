package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class OrgProfile extends Activity {
	SQLiteDatabase db;
String oname,rno,warea,exp,novol,phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_org_profile);
		final EditText et1=(EditText)findViewById(R.id.editText1);
		final EditText et2=(EditText)findViewById(R.id.editText2);
		final EditText et3=(EditText)findViewById(R.id.editText3);
		final EditText et4=(EditText)findViewById(R.id.editText4);
		final EditText et5=(EditText)findViewById(R.id.editText5);
		final EditText et6=(EditText)findViewById(R.id.editText6);
		Intent it=getIntent();
		 oname=it.getStringExtra("oname");
	     rno=it.getStringExtra("rno");
	     db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
			Cursor c=db.rawQuery("select * from organizationreg where rno='"+rno+"'", null);
			try{
			c.moveToFirst();
			if(c!=null){
				do {
					oname=c.getString(0);
					rno=c.getString(1);
					warea=c.getString(2);
					exp=c.getString(3);
					novol=c.getString(4);
					phone=c.getString(5);
					
				} while (c.moveToNext());
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(), "Details not found ", 100).show();
			}
			et1.setText(oname);
			et2.setText(rno);
			et3.setText(warea);
			et4.setText(exp);
			et5.setText(novol);
			et6.setText(phone);
			}
		


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_org_profile, menu);
		return true;
	}

}
