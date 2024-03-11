package com.example.foodshare;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ViewHistoryRest extends Activity {
ArrayList<String> al=new ArrayList<String>();
SQLiteDatabase db;
String fname,rno;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_history_rest);
		final ListView lv=(ListView)findViewById(R.id.listView1);
		lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,al));
		Intent it=getIntent();
		 rno=it.getStringExtra("rno");
		db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
		Cursor c=db.rawQuery("select * from addfoodres where rno='"+rno+"'", null);
		try{
		c.moveToFirst();
		if(c!=null){
			do {
				fname=c.getString(1);
				al.add(fname);
			
				
			} while (c.moveToNext());
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(getApplicationContext(), "Food Details not found ", 100).show();
		}
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String fname=lv.getItemAtPosition(arg2).toString();
				Intent it=new Intent(ViewHistoryRest.this,ViewHistoryRestMain.class);
				it.putExtra("rno", rno);
				it.putExtra("fname", fname);
				
				startActivity(it);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_history_rest, menu);
		return true;
	}

}
