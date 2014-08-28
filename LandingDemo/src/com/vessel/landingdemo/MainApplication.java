package com.vessel.landingdemo;

import com.vessel.VesselSDK;

import android.app.Application;

/**
 * Application object, which initializes VesselSDK on startup.
 * @author dev
 *
 */
public class MainApplication extends Application {

    // This is sample app key. Register your application.
    // And set the secret key.
    final String YOUR_SECRET_KEY = "NENaQXFFdnl6SVJXcGF0VHhxZ2xTSGtW";

    @Override
    public void onCreate() {
        super.onCreate();
        // Lets initialize VesselSDK using application secret key.
        VesselSDK.initialize(getApplicationContext(), YOUR_SECRET_KEY);
    }

}
