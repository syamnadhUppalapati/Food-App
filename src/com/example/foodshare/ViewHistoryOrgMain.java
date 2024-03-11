package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ViewHistoryOrgMain extends Activity {
	
	String rno,fname,quantity,details,pickuplocation,pickupendtime,expiretime,cdate;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_history_org_main);
		EditText et1=(EditText)findViewById(R.id.editText1);
		EditText et2=(EditText)findViewById(R.id.editText2);
		EditText et3=(EditText)findViewById(R.id.editText3);
		EditText et4=(EditText)findViewById(R.id.editText4);
		EditText et5=(EditText)findViewById(R.id.editText5);
		EditText et6=(EditText)findViewById(R.id.editText6);
		EditText et7=(EditText)findViewById(R.id.editText7);
		EditText et8=(EditText)findViewById(R.id.editText8);
		ImageView iv=(ImageView)findViewById(R.id.imageView1);
		
		
		Intent it=getIntent();
		 rno=it.getStringExtra("rno");
		 fname=it.getStringExtra("fname");
		 db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
			Cursor c=db.rawQuery("select * from addfoodorg where rno='"+rno+"' and fname='"+fname+"'", null);
			try{
			c.moveToFirst();
			if(c!=null){
				do {
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
			et2.setText(rno);
			et3.setText(quantity);
			et4.setText(details);
			et5.setText(pickuplocation);
			et6.setText(pickupendtime);
			et7.setText(expiretime);
			et8.setText(cdate);
			iv.setImageResource(resID);
			
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_history_org_main, menu);
		return true;
	}

}
