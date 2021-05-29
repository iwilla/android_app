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
	//״̬�ı��������
	private OnCheckedChangeListener checkBox_listener =  new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked){
				Log.i("��ѡ��ť","ѡ����"+buttonView.getText().toString());
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
		Button submit = (Button)findViewById(R.id.register);//��ȡע�����id
		submit.setOnClickListener(new OnClickListener() {
		final CheckBox like1 = (CheckBox) findViewById(R.id.like1);
		final CheckBox like2 = (CheckBox) findViewById(R.id.like2);
		final CheckBox like3 = (CheckBox) findViewById(R.id.like3);
		String like = "";//����ϲ���Ŀγ�
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String user=((EditText) findViewById(R.id.re_username)).getText().toString();//��ȡ�û���
				String age =((EditText) findViewById(R.id.age)).getText().toString();//��ȡ����
				//��ȡ�Ա�
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
			
				//��ȡ�漮��Ϣ
//				
//				Spinner spinner = (Spinner) findViewById(R.id.spinner);
//			    String[] zhujiResult;
//			    zhujiResult = getResources().getStringArray(R.array.zhuji);//��ȡarray�ж����ֵ
//			   spinner.setOnItemSelectedListener(new OnItemSelectedListener() {//���spinner�����¼�
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
				Intent intent = new Intent(register.this,view1.class);//���ĸ�ҳ����ת�ĸ�ҳ��
				Bundle bundle = new Bundle();//������ʵ����һ��Bundle����
				bundle.putCharSequence("user", user);//�����û���
				bundle.putCharSequence("age", age);//��������
				bundle.putCharSequence("sex", sexResult);//�����Ա�
//				bundle.putCharSequence("zhuji", zhujiResult );
				bundle.putCharSequence("like", like);
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

