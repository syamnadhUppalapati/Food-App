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

public class UserReg extends Activity {
SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_reg);
		final EditText et1=(EditText)findViewById(R.id.editText1);
		final EditText et2=(EditText)findViewById(R.id.editText2);
		final EditText et3=(EditText)findViewById(R.id.editText3);
		Button bt=(Button)findViewById(R.id.button1);
		
bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String uname=et1.getText().toString();
				String address=et2.getText().toString();
				String phone=et3.getText().toString();
				
				db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
				db.execSQL("create table if not exists userreg(uname varchar,adr varchar,phone varchar)");
			db.execSQL("insert into userreg values('"+uname+"','"+address+"','"+phone+"')");
			Toast.makeText(getApplicationContext(), "Registered Successfully ", Toast.LENGTH_LONG).show();	
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_user_reg, menu);
		return true;
	}

}
