package com.vessel.ui;


import com.vessel.VesselAB;
import com.vessel.landingdemo.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentNew extends FragmentBase {

	public FragmentNew() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View newView = inflater.inflate(R.layout.new_fragment, container, false);
		TextView welcomeMsg = (TextView) newView.findViewById(R.id.welcome_text);
		welcomeMsg.setText( VesselAB.getValue("welcome_text", getString(R.string.welcome_msg)));
		return newView;
	}


}
