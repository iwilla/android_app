package com.examapplication;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class Myservice extends Service {
	private final IBinder binder = new MyBinder();
	private final Random generator = new Random();
	public class MyBinder extends Binder{
		Myservice getService(){
			return Myservice.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return binder;
	}
public int getRandomNumber(){
	return generator.nextInt(100);
}
}
