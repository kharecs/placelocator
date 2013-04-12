package com.example.statpro;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.Dialog;
import android.net.ParseException;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class WebViewActivity extends Activity {

	private WebView webView;
	String a;
	String start,end,hs,es,es1,es2,mid2;
	String way[],page;
	boolean b1;
	String tmp="";
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();
		setContentView(R.layout.webview);
		Bundle b=new Bundle();
		b=getIntent().getExtras();
		a=b.getString("start");
		Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		try {
			InputStream in=this.getAssets().open("fo1.txt");
			int size=in.available();
			byte[] buf=new byte[size];
			in.read(buf);
			hs=new String(buf);
			in.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			InputStream in=this.getAssets().open("fo2.txt");
			int size=in.available();
			byte[] buf=new byte[size];
			in.read(buf);
			es=new String(buf);
			in.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		////////////////
		page=hs+a+es;
		Dialog d=new Dialog(this);
		ScrollView sc=new ScrollView(this);
		TextView tv=new TextView(this);
		tv.setText(page);
		sc.addView(tv);
		d.setContentView(sc);
		//d.show();
		File root = new File (Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+"abcd.html");
		try {
			FileOutputStream out=new FileOutputStream(root);
			out.write(page.getBytes());
			out.close();
			Toast.makeText(getApplicationContext(), "Copied..!!", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	webView.loadData(page, "text/html", "UTF-8");
		webView.loadData( URLEncoder.encode(page).replaceAll("\\+"," "), "text/html", "utf-8" );
			//webView.loadUrl("file:///android_asset/directions-waypoints.html");
	}

}