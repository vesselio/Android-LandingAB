package com.vessel.ui;

import com.vessel.VesselAB;
import com.vessel.landingdemo.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOld extends FragmentBase {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View oldView = inflater.inflate(R.layout.old_fragment, container, false);
		TextView welcomeMsg = (TextView) oldView.findViewById(R.id.welcome_text);
		
		// Find and set the value if any variation is loaded.
		welcomeMsg.setText( VesselAB.getValue("welcome_text", getString(R.string.welcome_msg)));
		return oldView;
	}

}
