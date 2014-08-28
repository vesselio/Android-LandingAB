package com.vessel.landingdemo;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.vessel.VesselAB;
import com.vessel.enums.VesselEnums.TestVariation;
import com.vessel.interfaces.ABListener;
import com.vessel.ui.FragmentBase;
import com.vessel.ui.FragmentNormalEmail;
import com.vessel.ui.FragmentSocialEmail;

/**
 * Activity to demonstrate Signup OnBoarding A/B testing using Vessel listeners
 * and Fragments.
 * 
 * @author dev
 * 
 */
public class SignupActivity extends FragmentActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);

		if (savedInstanceState != null) {
			// if we're being restored from a previous state,
			// then we don't need to do anything and should return or else
			// we could end up with overlapping fragments.
			return;
		} else {
			// Or you can load specific test and make decision
			loadUi();
		}
	}

	/**
	 * This method checks the variation available with Vessel and loads
	 * appropriate fragment.
	 */
	protected void loadUi() {

		// We are running another test to decide between Social Sign up vs Email
		// Sign up
		VesselAB.getVariationForTest("socialemail", new ABListener() {

			@Override
			public void testNotAvailable(final TestVariation arg) {
				showEmailLoginFragment();
			}

			@Override
			public void testAvailable(final String testName,
					final TestVariation variation) {
				showSocialFragment();
				Log.d("VesselSDK", "HomeActivity - test loaded " + testName);
			}
		});
	}

	/**
	 * Show the Login with Social Fragment.
	 */
	protected void showSocialFragment() {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				FragmentBase newFrgment = new FragmentSocialEmail();

				getSupportFragmentManager().beginTransaction()
						.add(R.id.fragment_container, newFrgment).commit();
			}
		});
	}

	/**
	 * Show login with Email Flow.
	 */
	protected void showEmailLoginFragment() {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				FragmentBase newFrgment = new FragmentNormalEmail();

				getSupportFragmentManager().beginTransaction()
						.add(R.id.fragment_container, newFrgment).commit();
			}
		});
	}

	/**
	 * Callback when Sign Up with Facebook Button is clicked. Reports a
	 * checkpoint back to Vessel.
	 * 
	 * @param view
	 *            - Button which clicked.
	 */
	public void signUpWithFacebook(final View view) {
		Toast.makeText(getApplicationContext(),
				"signUpWithFacebook checkpoint", Toast.LENGTH_LONG).show();
		// Report Checkpoint to track funnel
		VesselAB.reportCheckpoint("signUpWithFacebook");
	}

	/**
	 * Callback when Sign Up with Google Plus Button is clicked. Reports a
	 * checkpoint back to Vessel.
	 * 
	 * @param view
	 *            - Button which clicked.
	 */
	public void signUpWithGplus(final View view) {
		Toast.makeText(getApplicationContext(), "signUpWithGplus checkpoint",
				Toast.LENGTH_LONG).show();

		// You can optionally report meta data at checkpoint e.g.
		try {
			JSONObject metaData = new JSONObject();
			metaData.put("paidUser", true);
			metaData.put("itemPurchased", "benz");
			metaData.put("adCampaign", "bannerAds");
			VesselAB.reportCheckpoint("signUpWithGPlus", metaData);
		} catch (JSONException e) {
			Log.e("LandingDemo", "JSONException " + e);
		}
	}

	/**
	 * Report checkpoint when Normal Signup button is clicked.
	 * 
	 * @param view
	 *            - Button that was clicked.
	 */
	public void normalSignUp(final View view) {
		Toast.makeText(getApplicationContext(), "normalSignUp checkpoint",
				Toast.LENGTH_LONG).show();
		VesselAB.reportCheckpoint("normalEmailSignUp");
	}

	@Override
	protected void onResume() {
		VesselAB.onResume(SignupActivity.this);
		super.onResume();
	}

	@Override
	protected void onPause() {
		VesselAB.onPause(SignupActivity.this);
		super.onPause();
	}

}
