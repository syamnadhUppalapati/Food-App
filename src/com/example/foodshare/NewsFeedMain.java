package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewsFeedMain extends Activity {
	SQLiteDatabase db;
    String fname,nop,dname,adr,details,cdate,des;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_feed_main);
		TextView tv1=(TextView)findViewById(R.id.textView1);
		TextView tv2=(TextView)findViewById(R.id.textView2);
		TextView tv3=(TextView)findViewById(R.id.textView3);
		/*TextView tv6=(TextView)findViewById(R.id.textView6);
		TextView tv7=(TextView)findViewById(R.id.textView7);
		TextView tv8=(TextView)findViewById(R.id.textView8);*/
		ImageView iv=(ImageView)findViewById(R.id.imageView1);
		
		Intent it=getIntent();
		 fname=it.getStringExtra("fname");
		 db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
			Cursor c=db.rawQuery("select * from fooddistribution where fname='"+fname+"'", null);
			try{
			c.moveToFirst();
			if(c!=null){
				do {
					nop=c.getString(1);
					dname=c.getString(2);
					adr=c.getString(3);
					details=c.getString(4);
					cdate=c.getString(5);
					des=c.getString(6);
					
				
					
				} while (c.moveToNext());
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(), "Food Details not found ", 100).show();
			}
			String data=details+" served "+nop+"people by "+dname+"  "+des;
			int  resID = getResources().getIdentifier(fname,"raw", getPackageName());  
			iv.setImageResource(resID);
			tv1.setText(cdate);
			/*tv2.setText(details);
			tv4.setText(nop);
			tv6.setText(dname);
			tv7.setText(des);*/
			tv2.setText(data);
			tv3.setText(adr);
	            
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_news_feed_main, menu);
		return true;
	}

}
