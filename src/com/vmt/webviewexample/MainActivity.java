package com.vmt.webviewexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private WebView webView;
    private EditText urlEditText;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	       urlEditText = (EditText) findViewById(R.id.urlField);
	        webView = (WebView) findViewById(R.id.webView);
	        webView.setWebViewClient(new MyWebViewClient());
	 
	        Button openUrl = (Button) findViewById(R.id.goButton);
	        openUrl.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                String url = urlEditText.getText().toString();
	                if(validateUrl(url)){
	                    webView.getSettings().setJavaScriptEnabled(true);
	                    webView.loadUrl(url);
	                }
	            }
	            private boolean validateUrl(String url) {
	                return true;
	            }
	        });    
	    }
	 
	    private class MyWebViewClient extends WebViewClient {
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            view.loadUrl(url);
	            return true;
	        }
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
