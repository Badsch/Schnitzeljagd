package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt;

import com.qualcomm.QCARSamples.CloudRecognition.CloudReco;
import com.qualcomm.QCARSamples.CloudRecognition.R;
import com.qualcomm.QCARSamples.CloudRecognition.R.layout;
import com.qualcomm.QCARSamples.CloudRecognition.R.menu;

import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.control.RouteController;
import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Route;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class TitleScreen extends Activity {

	private Button buttonStart;
	private RouteController routeController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_title_screen);
		routeController = RouteController.getRouteController();
		//routeController.getDefaultRoute();
		buttonStart = (Button) findViewById(R.id.buttonStart);
		
		
		
		// prüfe ob es eine aktive Route gibt
		if( routeController.getActiveRoute() == null){
			buttonStart.setEnabled(false);
		}
		else {
			buttonStart.setEnabled(true);
		}
		


		
		
	}
	
	public void scanRoute(View v){
		startARActivity();
	}
	
	/** Starts the CloudReco main activity */
    private void startARActivity()
    {
        Intent i = new Intent(this, CloudReco.class);
        startActivity(i);
    }
    
    

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startRoute(View v){
		Intent intent = new Intent(this, RouteActivity.class);
    	startActivity(intent);
	}

}
