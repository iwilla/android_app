package com.examapplication;

import com.examapplication.MainActivity.ButtonListener;
import com.examapplication.Myservice.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton; 
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class register extends Activity {
	boolean bound = false;
	Myservice MyService;
	private ServiceConnection connection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			bound = false;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			MyBinder binder = (MyBinder) service;
			MyService = binder.getService();
			bound = true;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);	
		Button submit = (Button)findViewById(R.id.register);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String user=((EditText) findViewById(R.id.re_username)).getText().toString();
				String age =((EditText) findViewById(R.id.age)).getText().toString();
				Intent intent = new Intent(register.this,view1.class);//���ĸ�ҳ����ת�ĸ�ҳ��
				Bundle bundle = new Bundle();//������ʵ����һ��Bundle����
				bundle.putCharSequence("user", user);//�����û���
				bundle.putCharSequence("age", age);//��������
				intent.putExtras(bundle);//��bundle������ӵ�intent������
				startActivity(intent);//�����µ�activty
			}
		});
		}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Intent intent = new Intent (this,Myservice.class);
		
		bindService(intent, connection, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		if(bound){
			unbindService(connection);
			bound = false;
		}
	}
	public void onBottonClick(View v){
		if(bound){
			int num = MyService.getRandomNumber();
			TextView tv = (TextView)findViewById(R.id.randomshow);
			tv.setText("�����������Ϊ"+num);
			
		}
	}
	
	

}

