package com.example.foodshare;

import java.security.SecureRandom;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Second extends Activity {
	int range = 9;  // to generate a single number with this range, by default its 0..9
	int length = 4; // by default length is 4
	int randomNumber;
	String otp;
	SQLiteDatabase db;
String phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		final EditText et=(EditText)findViewById(R.id.editText1);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			String phone=et.getText().toString();
			generateRandomNumber();
			  otp=""+randomNumber;
				db=openOrCreateDatabase("foodconservation", MODE_PRIVATE, null);
				db.execSQL("create table if not exists checkotp(phone varchar,otp varchar)");
			db.execSQL("insert into checkotp values('"+phone+"','"+otp+"')");
			Toast.makeText(getApplicationContext(), " enter otp", 100).show();
			 SmsManager sms=SmsManager.getDefault();
             sms.sendTextMessage(phone,null,""+randomNumber,null,null);
              

            Intent it=new Intent(Second.this,CheckOtp.class);
            it.putExtra("phone", phone);
            it.putExtra("otp", otp);
            startActivity(it);

			}
		});
	}
	
	
	
	
	 public int generateRandomNumber() {


	        SecureRandom secureRandom = new SecureRandom();
	        String s = "";
	        for (int i = 0; i < length; i++) {
	            int number = secureRandom.nextInt(range);
	            if (number == 0 && i == 0) { // to prevent the Zero to be the first number as then it will reduce the length of generated pin to three or even more if the second or third number came as zeros
	                i = -1;
	                continue;
	            }
	            s = s + number;
	        }

	        randomNumber = Integer.parseInt(s);

	        return randomNumber;
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_second, menu);
		return true;
	}

}
