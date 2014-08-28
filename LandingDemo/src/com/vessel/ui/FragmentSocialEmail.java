package com.vessel.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vessel.VesselAB;
import com.vessel.landingdemo.R;


/**
 * Social Signup Fragment.
 * @author dev
 *
 */
public class FragmentSocialEmail extends FragmentBase {

	public FragmentSocialEmail() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View newView = inflater.inflate(R.layout.social_signup, container, false);
		TextView welcomeMsg = (TextView) newView.findViewById(R.id.welcome_text);
		final ImageView logo = (ImageView) newView.findViewById(R.id.vessel_logo);

		// Find and set the value if any variation is loaded.
		welcomeMsg.setText(VesselAB.getValue("socialemail", "welcome_text",
		        getString(R.string.welcome_msg)));
		return newView;
	}
}
