package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DonorDetails extends Activity {
String dname,fname,noofpeople,cdate,adr,details,des;
SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donor_details);
		EditText et1=(EditText)findViewById(R.id.editText1);
		EditText et2=(EditText)findViewById(R.id.editText2);
		final EditText et3=(EditText)findViewById(R.id.editText3);
		final EditText et4=(EditText)findViewById(R.id.editText4);
		EditText et5=(EditText)findViewById(R.id.editText5);
		final EditText et6=(EditText)findViewById(R.id.editText6);
		ImageView iv=(ImageView)findViewById(R.id.imageView1);
		Button bt=(Button)findViewById(R.id.button1);
		Intent it=getIntent();
		 dname=it.getStringExtra("uname");
		 fname=it.getStringExtra("fname");
		 noofpeople=it.getStringExtra("quantity");
		 cdate=it.getStringExtra("cdate");
		int  resID = getResources().getIdentifier(fname,"raw", getPackageName());  
		et1.setText(noofpeople);
		et2.setText(dname);
		et5.setText(cdate);
		iv.setImageResource(resID);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 adr=et3.getText().toString();
				 details=et4.getText().toString();
				 des=et6.getText().toString();
				 try{
			            db=openOrCreateDatabase("foodconservation",MODE_PRIVATE,null);
			            db.execSQL("create table if not exists fooddistribution(fname varchar,nop varchar,dname varchar,adr varchar,details varchar,cdate varchar,des varchar)");
			            db.execSQL("insert into fooddistribution values('"+fname+"','"+noofpeople+"','"+dname+"','"+adr+"','"+details+"','"+cdate+"','"+des+"')");
			            Toast.makeText(getApplicationContext(),"Food distributed Successfully",Toast.LENGTH_LONG).show();
			            }catch (Exception e) {
							// TODO: handle exception
			            	Toast.makeText(getApplicationContext(),"Food not distributed ",Toast.LENGTH_LONG).show();
						}
			            }	
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_donor_details, menu);
		return true;
	}

}
