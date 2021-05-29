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
		Intent intent =getIntent(); //获取intent对象
		Bundle bundle = intent.getExtras(); //获取传递的数据包		
		TextView user =(TextView) findViewById(R.id.user);//获取显示textview组件的id
		user.setText("用户名"+bundle.getString("user"));		//显示到textview组件上
		TextView age = (TextView) findViewById(R.id.age);//获取显示textview组件的id
		age.setText("年龄"+bundle.getString("age"));	//显示到textview组件上
		TextView sex  =(TextView) findViewById(R.id.sex);
		sex.setText("性别："+bundle.getString("sex"));
		TextView like = (TextView) findViewById(R.id.likeShow);
		like.setText("喜欢的课程："+bundle.getString("like"));
		 
		
		
	}
	
	
}
