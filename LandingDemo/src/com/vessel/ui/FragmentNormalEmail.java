package com.vessel.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vessel.VesselAB;
import com.vessel.interfaces.VesselImageListener;
import com.vessel.landingdemo.R;

import external.com.android.volley.VolleyError;
import external.com.android.volley.toolbox.ImageLoader.ImageContainer;

/**
 * Fragment loading Normail Email. Demonstrates loading of assets and strings
 * from Vessel Server. 
 * @author dev
 *
 */
public class FragmentNormalEmail extends FragmentBase {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View emailView = inflater.inflate(R.layout.email_signup, container, false);
        TextView welcomeMsg = (TextView) emailView.findViewById(R.id.welcome_text);
        final ImageView logo = (ImageView) emailView.findViewById(R.id.vessel_logo);

        // Find and set the value if any variation is loaded.
        welcomeMsg.setText(VesselAB.getValue("socialemail", "welcome_text",
                getString(R.string.welcome_msg)));
        VesselAB.getImageForKey("socialemail", "signuplogo", new VesselImageListener() {

            @Override
            public void onResponse(ImageContainer container, boolean isImmediate) {
                if (container != null) {
                    logo.setImageBitmap(container.getBitmap());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });

        return emailView;
    }

}
