package com.example.foodshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrgLogin extends Activity {

	SQLiteDatabase db;
	String username,password,uname,pwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_org_login);
		final EditText et1=(EditText)findViewById(R.id.editText1);
		final EditText et2=(EditText)findViewById(R.id.editText2);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				username=et1.getText().toString();
				 password=et2.getText().toString();
				
				db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
				Cursor c=db.rawQuery("select * from organizationreg where oname='"+username+"' and rno='"+password+"'", null);
				try{
				c.moveToFirst();
				if(c!=null){
					do {
						int i=c.getColumnIndex("oname");
						 uname=c.getString(i);
						int j=c.getColumnIndex("rno");
						 pwd=c.getString(j);
						 if(username.equalsIgnoreCase(uname)&&(password.equalsIgnoreCase(pwd))){
								Intent it=new Intent(OrgLogin.this,OrgHome.class);
								it.putExtra("oname", uname);
								it.putExtra("rno", pwd);
								
								startActivity(it);
							}
						
					} while (c.moveToNext());
				}
				
				}catch (Exception e) {
					// TODO: handle exception
					Toast.makeText(getApplicationContext(), "invalid username and password ", 100).show();
				}
				}
			});
			
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_org_login, menu);
		return true;
	}

}
