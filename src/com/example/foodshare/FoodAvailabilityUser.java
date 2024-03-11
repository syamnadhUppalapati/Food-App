package com.example.foodshare;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class FoodAvailabilityUser extends Activity {
	SQLiteDatabase db;
	ArrayList<String> al=new ArrayList<String>();
	String food,quantity,details,pickuplocation,pickupendtime,expirationtime,uname,phone,date;
ImageView iv;
int resID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_availability_user);
		Intent it=getIntent();
		 phone=it.getStringExtra("phone");
		 uname=it.getStringExtra("uname");
		final EditText et1=(EditText)findViewById(R.id.editText1);
		final EditText et2=(EditText)findViewById(R.id.editText2);
		final EditText et3=(EditText)findViewById(R.id.editText3);
		final EditText et4=(EditText)findViewById(R.id.editText4);
		final EditText et5=(EditText)findViewById(R.id.editText5);
		final Spinner sp=(Spinner)findViewById(R.id.spinner1);
		 iv=(ImageView)findViewById(R.id.imageView1);
		Button bt=(Button)findViewById(R.id.button1);
		
		
		 
		  date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
		
		al.add("biryani");
		al.add("chickencurry");
		al.add("idly");
		al.add("item1");
		al.add("item2");
		al.add("item3");
		al.add("item4");
		al.add("item5");
		al.add("meals");
		al.add("muttoncurry");
		al.add("vada");
		sp.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,al));
	sp.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			food=sp.getItemAtPosition(arg2).toString();
		
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	
	bt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            quantity = et1.getText().toString();
            details=et2.getText().toString();
            pickuplocation=et3.getText().toString();
            pickupendtime=et4.getText().toString();
            expirationtime=et5.getText().toString();
          
           
            
           
            resID = getResources().getIdentifier(food,"raw", getPackageName());  
            
            
            iv.setImageResource(resID);
            
          
            
            try{
            db=openOrCreateDatabase("foodconservation",MODE_PRIVATE,null);
            db.execSQL("create table if not exists addfooduser(uname varchar,phone varchar,fname varchar,quantity varchar,details varchar,pickuplocation varchar,pickupendtime varchar,expirationtime varchar,cdate varchar)");
            db.execSQL("insert into addfooduser values('"+uname+"','"+phone+"','"+food+"','"+quantity+"','"+details+"','"+pickuplocation+"','"+pickupendtime+"','"+expirationtime+"','"+date+"')");
            Toast.makeText(getApplicationContext(),"Food added Successfully",Toast.LENGTH_LONG).show();
            }catch (Exception e) {
				// TODO: handle exception
            	Toast.makeText(getApplicationContext(),"Food not added ",Toast.LENGTH_LONG).show();
			}
            }
    });

	
	}


		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_food_availability_user, menu);
		return true;
	}

}
