package com.example.foodshare;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RestarentReg extends Activity {

	ArrayList<String> al=new ArrayList<String>();
	String rtype;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restarent_reg);
		final Spinner sp=(Spinner)findViewById(R.id.spinner1);
		final EditText et1=(EditText)findViewById(R.id.editText1);
		final EditText et2=(EditText)findViewById(R.id.editText2);
		final EditText et3=(EditText)findViewById(R.id.editText3);
		final EditText et4=(EditText)findViewById(R.id.editText4);
		Button bt=(Button)findViewById(R.id.button1);
		al.add("Fine Dining");
		al.add("Casual Dining");
		al.add("Family Style");
		al.add("Fast Food");
		al.add("Buffet");
		al.add("Food Trucks and Concession Stands");
		
		sp.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,al));
		
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				rtype=sp.getItemAtPosition(arg2).toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String rname=et1.getText().toString();
				String rno=et2.getText().toString();
				String address=et3.getText().toString();
				String phone=et4.getText().toString();
				
				db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
				db.execSQL("create table if not exists restarentreg(rname varchar,rno varchar,rtype varchar,adr varchar,phone varchar)");
			db.execSQL("insert into restarentreg values('"+rname+"','"+rno+"','"+rtype+"','"+address+"','"+phone+"')");
			Toast.makeText(getApplicationContext(), "Registered Successfully ", Toast.LENGTH_LONG).show();	
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_restarent_reg, menu);
		return true;
	}

}
