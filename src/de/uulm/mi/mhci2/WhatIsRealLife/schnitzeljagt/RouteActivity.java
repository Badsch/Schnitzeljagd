package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt;

import com.qualcomm.QCARSamples.CloudRecognition.CloudReco;
import com.qualcomm.QCARSamples.CloudRecognition.R;
import com.qualcomm.QCARSamples.CloudRecognition.R.layout;
import com.qualcomm.QCARSamples.CloudRecognition.R.menu;

import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.control.RouteController;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class RouteActivity extends Activity {
	
	
	
	private RouteController routeController;

	//private Button startButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_route);
		
		routeController = RouteController.getRouteController();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.route, menu);
		return true;
	}
	
	
	
    /** Starts the CloudReco main activity */
    private void startARActivity()
    {
        Intent i = new Intent(this, CloudReco.class);
        startActivity(i);
    }
    
    public void onClick(View v)
    {
    	
    	startARActivity();
    	/*
        switch (v.getId())
        {
        case R.id.button_start:
            startARActivity();
            break;
        }
        */
    }

}
