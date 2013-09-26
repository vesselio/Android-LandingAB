package com.vessel.landingdemo;

import com.vessel.VesselAB;
import com.vessel.enums.VesselEnums.TestVariation;
import com.vessel.interfaces.ABListener;
import com.vessel.ui.FragmentBase;
import com.vessel.ui.FragmentNew;
import com.vessel.ui.FragmentOld;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends FragmentActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		
		
		VesselAB.reloadTest();
		if (savedInstanceState != null) {
			//if we're being restored from a previous state,
			// then we don't need to do anything and should return or else
			// we could end up with overlapping fragments.
			return;
		}else{
			// compare variations and make decision directly.
			initUi();
			
			// Or you can load specific test and make decision 
			// loadUi();
		}
	}


	protected void initUi() {
		// If you know test is loaded then you can simply 
		// compare against variations and make decision.
		FragmentBase newFrgment ;
		if(VesselAB.whichVariation() == TestVariation.A){
			// Load new fragment, else fail over to old fragment
			newFrgment = new FragmentNew();
		}else{
			newFrgment = new FragmentOld();
		}
		getSupportFragmentManager().beginTransaction()
		.add(R.id.fragment_container, newFrgment).commit();
		Toast.makeText(getApplicationContext(), "Currently we have variation "+ VesselAB.whichVariation(), Toast.LENGTH_LONG).show();
	}

	// Optional
	protected void loadUi() {
		// Find and load particular test
		VesselAB.getVariationByTestName("SignUpScreen", new ABListener() {

			@Override
			public void testNotAvailable(TestVariation arg0) {
				initUi();

			}

			@Override
			public void testLoading() {
				// TODO Auto-generated method stub

			}

			@Override
			public void testLoaded(String testName, TestVariation variation) {
				initUi();
			}
		});
	}


	public void signUpWithFacebook(View v) {
		Toast.makeText(getApplicationContext(), "signUpWithFacebook checkpoint", Toast.LENGTH_LONG).show();
		
		// Report Checkpoint to track funnel
		VesselAB.checkPointVisited("signUpWithFacebook");
	}

	public void signUpWithGplus(View v){
		Toast.makeText(getApplicationContext(), "signUpWithGplus checkpoint", Toast.LENGTH_LONG).show();
		VesselAB.checkPointVisited("signUpWithGPlus");
	}
	

	public void normalSignUp(View v){
		Toast.makeText(getApplicationContext(), "normalSignUp checkpoint", Toast.LENGTH_LONG).show();
		VesselAB.checkPointVisited("normalSignUp");
	}
	
	@Override
	protected void onResume() {
		VesselAB.onResume();
		super.onResume();
	}

	@Override
	protected void onPause() {
		VesselAB.onPause();
		super.onPause();
	}

}
