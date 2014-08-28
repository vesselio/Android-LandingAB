package com.vessel.landingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vessel.VesselAB;

/**
 * This your dummy guide Activity
 *
 */
public class GuideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        // Track how much time users are spending in user guide
        VesselAB.startSession("InUserGuide");
    }

    @Override
    protected void onResume() {
        VesselAB.onResume(GuideActivity.this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        VesselAB.onPause(GuideActivity.this);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void skipGuide(View v){
        VesselAB.endSession("InUserGuide");
        VesselAB.reportCheckpoint("skippedOnboarding");
        Intent intent = new Intent();
        intent.setClass(GuideActivity.this, SignupActivity.class);
        startActivity(intent);
        finish();
    }
}
