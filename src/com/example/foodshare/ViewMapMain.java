package com.example.foodshare;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled")
public class ViewMapMain extends Activity {
	 String url, source, dest;

	    WebView wv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_map_main);
		 wv = (WebView) findViewById(R.id.webView1);
	        Intent it=getIntent();
	        source=it.getStringExtra("source");
	        dest=it.getStringExtra("destination");




	        wv.getSettings().setJavaScriptEnabled(true);
	        wv.requestFocus(View.FOCUS_DOWN);
	           wv.getSettings().setJavaScriptEnabled(true);
	        wv.getSettings().setLoadsImagesAutomatically(true);
	        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
	        wv.setWebViewClient(new MyBrowser());
	        wv.loadUrl("https://www.mapdevelopers.com/distance_from_to.php?&from="+source+"&to="+dest);

	    }




	    private class MyBrowser extends WebViewClient {
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            view.loadUrl(url);
	            view.addJavascriptInterface(new Object() {
	                @JavascriptInterface
	                public void performClick() throws Exception {
	                    Log.d("LOGIN::", "Clicked");
	                    Toast.makeText(ViewMapMain.this, "Login clicked", Toast.LENGTH_LONG).show();

	                }
	            }, "login");
	            return true;
	        }
	    }
	}
