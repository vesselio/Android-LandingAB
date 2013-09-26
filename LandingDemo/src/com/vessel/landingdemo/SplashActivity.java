package com.vessel.landingdemo;


import com.vessel.VesselAB;
import com.vessel.enums.VesselEnums.TestVariation;
import com.vessel.interfaces.ABListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_main);
		
		VesselAB.reloadTest();
		VesselAB.setABListener(new ABListener() {
			
			@Override
			public void testNotAvailable(TestVariation arg0) {
				// Go to home activity once test is loaded or not available 
				gotoHome();
			}
			
			@Override
			public void testLoading() {
				// Show loading animations.
			}
			
			@Override
			public void testLoaded(String s, TestVariation arg1) {
				gotoHome();
			}
		});
		
	}

	protected void gotoHome() {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, HomeActivity.class);
				startActivity(intent);
				finish();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
