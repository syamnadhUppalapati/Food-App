package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrganizationReg extends Activity {
SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_organization_reg);
		final EditText et1=(EditText)findViewById(R.id.editText1);
		final EditText et2=(EditText)findViewById(R.id.editText2);
		final EditText et3=(EditText)findViewById(R.id.editText3);
		final EditText et4=(EditText)findViewById(R.id.editText4);
		final EditText et5=(EditText)findViewById(R.id.editText5);
		final EditText et6=(EditText)findViewById(R.id.editText6);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String oname=et1.getText().toString();
				String rno=et2.getText().toString();
				String warea=et3.getText().toString();
				String experience=et4.getText().toString();
				String novol=et5.getText().toString();
				String phone=et6.getText().toString();
				
				db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
				db.execSQL("create table if not exists organizationreg(oname varchar,rno varchar,warea varchar,exp varchar,novol varchar,phone varchar)");
			db.execSQL("insert into organizationreg values('"+oname+"','"+rno+"','"+warea+"','"+experience+"','"+novol+"','"+phone+"')");
			Toast.makeText(getApplicationContext(), "Registered Successfully ", Toast.LENGTH_LONG).show();	
				
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_organization_reg, menu);
		return true;
	}

}
