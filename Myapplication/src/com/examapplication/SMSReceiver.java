package com.examapplication;

import com.examapplication.R.string;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		final String action ="android.provider.Telephony.SMS_RECEIVED";
		// TODO Auto-generated method stub
		if(intent.getAction().equals(action)){
			Toast.makeText(context, context.getResources().getString(R.string.message), Toast.LENGTH_LONG).show();
		}

	}

}
