package com.examapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class view1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view1);	
		Intent intent =getIntent(); //��ȡintent����
		Bundle bundle = intent.getExtras(); //��ȡ���ݵ����ݰ�		
		TextView user =(TextView) findViewById(R.id.user);//��ȡ��ʾtextview�����id
		user.setText("�û���"+bundle.getString("user"));	
		TextView age = (TextView) findViewById(R.id.age);//��ȡ��ʾtextview�����id
		//��ʾ��textview�����
		
		age.setText("����"+bundle.getString("age"));
		 
		
		
	}
	
	
}
