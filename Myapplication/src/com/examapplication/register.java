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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton; 
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class register extends Activity {
	boolean bound = false;
	Myservice MyService;
	//状态改变监听对象
	private OnCheckedChangeListener checkBox_listener =  new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked){
				Log.i("复选按钮","选中了"+buttonView.getText().toString());
			}
		}
	};
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
		Button button = (Button) findViewById(R.id.tiaozhuan);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				startActivity(intent);
			}
		});
		Button submit = (Button)findViewById(R.id.register);//获取注册键的id
		submit.setOnClickListener(new OnClickListener() {
		final CheckBox like1 = (CheckBox) findViewById(R.id.like1);
		final CheckBox like2 = (CheckBox) findViewById(R.id.like2);
		final CheckBox like3 = (CheckBox) findViewById(R.id.like3);
		String like = "";//定义喜欢的课程
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String user=((EditText) findViewById(R.id.re_username)).getText().toString();//获取用户名
				String age =((EditText) findViewById(R.id.age)).getText().toString();//获取年龄
				//获取性别
				final RadioGroup sex =(RadioGroup) findViewById(R.id.sex);
				String sexResult = null;
				for(int i = 0;i<sex.getChildCount();i++){
					RadioButton r = (RadioButton) sex.getChildAt(i);
					if(r.isChecked()){
					 sexResult = (String) r.getText();
						break;
					}
					
				}
				if(like1.isChecked()){
					like+=like1.getText().toString();
				}
				if(like2.isChecked()){
					like+=like2.getText().toString();
				}
				if(like3.isChecked()){
					like+=like3.getText().toString();
				}
			
				//获取祖籍消息
//				
//				Spinner spinner = (Spinner) findViewById(R.id.spinner);
//			    String[] zhujiResult;
//			    zhujiResult = getResources().getStringArray(R.array.zhuji);//获取array中定义的值
//			   spinner.setOnItemSelectedListener(new OnItemSelectedListener() {//添加spinner监听事件
//
//				@Override
//				public void onItemSelected(AdapterView<?> parent, View view,
//						int position, long id) {
//					// TODO Auto-generated method stub
//					zhujiResult = parent.getItemAtPosition(position).toString();
//					
//				}
//
//				@Override
//				public void onNothingSelected(AdapterView<?> parent) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//				String like = (EditText)
				Intent intent = new Intent(register.this,view1.class);//从哪个页面跳转哪个页面
				Bundle bundle = new Bundle();//创建并实例化一个Bundle对象
				bundle.putCharSequence("user", user);//保存用户名
				bundle.putCharSequence("age", age);//保存年龄
				bundle.putCharSequence("sex", sexResult);//保存性别
//				bundle.putCharSequence("zhuji", zhujiResult );
				bundle.putCharSequence("like", like);
				intent.putExtras(bundle);//将bundle对象添加到intent对象中
				startActivity(intent);//启动新的activty
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
			tv.setText("产生的随机数为"+num);
			
		}
	}
	
	

}

