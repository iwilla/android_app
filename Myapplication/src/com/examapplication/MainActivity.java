package com.examapplication;

import android.app.Activity;
import android.app.SearchManager.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageButton login = (ImageButton) findViewById(R.id.login_button);
		ImageButton register = (ImageButton) findViewById(R.id.regester_button);
		
		login.setOnClickListener(new ButtonListener());
		register.setOnClickListener(new ButtonListener());
	
	}
	class ButtonListener implements OnClickListener{
		final EditText username_value = (EditText) findViewById(R.id.username);
		final EditText password_value = (EditText) findViewById(R.id.passwrod);
		public void onClick(View v){
			switch(v.getId()){
			case R.id.login_button:
				String result1 = username_value.getText().toString();
				String result2 = password_value.getText().toString();
				Toast.makeText(MainActivity.this,"”√ªß√˚:"+result1+"√‹¬Î£∫"+result2,Toast.LENGTH_LONG).show();
				break;
			case R.id.regester_button:
				Intent intent = new Intent(MainActivity.this,register.class);
				startActivity(intent);
				break;
				default:
					break;
			}
		}
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

