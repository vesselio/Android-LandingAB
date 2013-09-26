package com.vessel.landingdemo;

import com.vessel.VesselSDK;

import android.app.Application;

public class MainApplication extends Application {
	final String YOUR_SECRET_KEY = "TUhCR1FqN1VrbnJxQVk2bWxDZzNKYU9z";
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		VesselSDK.initialize(getApplicationContext(), YOUR_SECRET_KEY);
	}

}
