package com.vessel.landingdemo;


import com.vessel.VesselAB;
import com.vessel.enums.VesselEnums.TestVariation;
import com.vessel.interfaces.ABListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Space;
import android.widget.Toast;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_main);
		
		VesselAB.getVariationForTest("onboarding", new ABListener() {
			
			@Override
			public void testNotAvailable(TestVariation arg0) {
				showSignUpActivity();
			}
			

			@Override
			public void testAvailable(String arg0, TestVariation arg1) {
				showUserGuideActivity();
			}
		});
		
	}
	
	protected void showUserGuideActivity() {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				Toast.makeText(getApplicationContext(), "Test loaded successfully, show user guide.", Toast.LENGTH_LONG).show();
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, GuideActivity.class);
				startActivity(intent);
				finish();

			}
		});
		
	}

	private void showSignUpActivity() {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				Toast.makeText(getApplicationContext(), "Test is not available for this device, showing login screen.", Toast.LENGTH_LONG).show();
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, SignupActivity.class);
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
	
	@Override
	protected void onResume() {
		VesselAB.onResume(SplashActivity.this);
		super.onResume();
	}

	@Override
	protected void onPause() {
		VesselAB.onPause(SplashActivity.this);
		super.onPause();
	}
}
