package com.example.statpro;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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

import android.net.ParseException;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
Spinner spinner1,spinner2;
Button btn;
InputStream is;
String result,error,id;
    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    	addListenerOnSpinnerItemSelection();
    }
    public void addListenerOnSpinnerItemSelection() {
    	 spinner1 = (Spinner) findViewById(R.id.sp1);
    	
    		}
     
      // get the selected dropdown list value
      public void addListenerOnButton() {
     
    	spinner1 = (Spinner) findViewById(R.id.sp1);
    	btn = (Button) findViewById(R.id.b1);
    	btn.setOnClickListener(new OnClickListener() {     
    	  public void onClick(View v) {
    	    Toast.makeText(MainActivity.this,
    		"OnClickListener : " + 
                    "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) ,
    			Toast.LENGTH_SHORT).show();
    			
    	//
    	
        		String a=String.valueOf(spinner1.getSelectedItem());
    		///
            Intent intent=new Intent(MainActivity.this,WebViewActivity.class);
            Bundle bundle = new Bundle();   
            bundle.putString("start",a);  
            Toast.makeText(MainActivity.this,
            		"OnClickListener : " + 
                            "\na : "+ a ,
            			Toast.LENGTH_SHORT).show();
            //bundle.putInt("value",variablename);
            intent.putExtras(bundle);   
           startActivity(intent);                 
    	  }
    		/////////
    	});
      }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
