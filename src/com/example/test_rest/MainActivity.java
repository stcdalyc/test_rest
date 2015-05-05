package com.example.test_rest;

import java.io.File;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

	@Bean
	ApiHelper api;

	@ViewById
	WebView webview;
	
	@ViewById
	EditText edit;
	
	DiskBasedCache cache;
	RequestQueue mRequestQueue;
	@AfterViews
	void init(){
		File cacheDirectory = new File( getCacheDir() + "/html" );
		if(! cacheDirectory.exists()) cacheDirectory.mkdirs();
		cache = new DiskBasedCache(cacheDirectory , 1024 * 1024);
		cache.initialize();
		//cache.clear();

		// Set up the network to use HttpURLConnection as the HTTP client.
		Network network = new BasicNetwork(new HurlStack());

		// Instantiate the RequestQueue with the cache and network.
		mRequestQueue = Volley.newRequestQueue(this);
		//mRequestQueue.start();
		webview.setWebViewClient(new WebViewClient(){
			public boolean shouldOverrideUrlLoading(WebView view,String url){ 
				edit.setText(url);
				search();
				return true;
			}
		});
		search();
	}
	
	@Click
	void search(){
		final String http = edit.getText().toString();
		Cache.Entry entry =  cache.get(http);
		if(entry != null){
			String arg0 = new String(entry.data);
			webview.loadDataWithBaseURL(http, arg0, "text/html", "utf-8", null);
			//webview.loadData(String.valueOf(entry.data), "text/html", "utf-8");
		}else{
			StringRequest request = new StringRequest(Request.Method.GET,http, new Response.Listener<String>() {

				@Override
				public void onResponse(String arg0) {
					Cache.Entry entry = new Cache.Entry();
					entry.data = arg0.getBytes();
					cache.put(http, entry);
					// webview.loadData(arg0, "text/html", "utf-8");
					webview.loadDataWithBaseURL(http, arg0, "text/html", "utf-8", null);
				}
			}, null);
			mRequestQueue.add(request);
		}
		//webview.load
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
