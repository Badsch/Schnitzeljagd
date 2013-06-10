package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt;

import com.qualcomm.QCARSamples.CloudRecognition.CloudReco;
import com.qualcomm.QCARSamples.CloudRecognition.R;

import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.control.RouteController;
import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Location;

import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
<<<<<<< HEAD
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> be16e16bc37c2adfd3339f67bd4242f67b2a8c81
=======
>>>>>>> be16e16bc37c2adfd3339f67bd4242f67b2a8c81

public class RouteActivity extends Activity {
		
	private RouteController routeController;
<<<<<<< HEAD
	private Location activeLocation;	
	
=======
	private Location activeLocation;
	
	
<<<<<<< HEAD
	
>>>>>>> be16e16bc37c2adfd3339f67bd4242f67b2a8c81
=======
	private RouteController routeController;
	private Location activeLocation;
	
	
	
>>>>>>> be16e16bc37c2adfd3339f67bd4242f67b2a8c81
	private android.location.Location currentLocation;
	private android.location.Location targetLocation;
	private float distance = 0;
	
	private LocationManager lm;
	
	private TextView locationTitle;
	private TextView routeTitle;
	
	

	//private Button startButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_route);
		
		routeController = RouteController.getRouteController();
		activeLocation = routeController.getActiveRoute().getCurrendLocation();
		setViewText();
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		activeLocation = routeController.getActiveRoute().getCurrendLocation();
		setViewText();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		activeLocation = routeController.getActiveRoute().getCurrendLocation();
		setViewText();
	}
	
	
	
	private void setViewText(){
		//TODO fill me biatch!!!!!!
<<<<<<< HEAD
<<<<<<< HEAD
		
		locationTitle =(TextView)findViewById(R.id.LocationTitle); 
		locationTitle.setText(activeLocation.getTitle());
		
=======
>>>>>>> be16e16bc37c2adfd3339f67bd4242f67b2a8c81
=======
>>>>>>> be16e16bc37c2adfd3339f67bd4242f67b2a8c81
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
        
        finish();
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
    
    
    
    /**
     *  Hier wird alles initialisiert was man für die GPS Sachen braucht. 
     */
	private void initLocationManager(){		
		
		if(lm != null){
			lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		}
		  	
    	
		// Listener für GPS
    	final LocationListener locationListener = new android.location.LocationListener() {
    		    		
    		public void onLocationChanged(android.location.Location l) {
  	         
    		//TextView tv = new TextView(gpstracker.this);
  	         //t.setText("lat: " + l.getLatitude() + "\nlon: " + l.getLongitude());
  	         //setContentView(t);
  	         
    			targetLocation.setLatitude(l.getLatitude());
    			targetLocation.setLongitude(l.getLongitude());  	         
  	         
    			distance = targetLocation.distanceTo(currentLocation);
  	       
         
    		}
	
			@Override
				public void onProviderDisabled(String provider) {
					// TODO Auto-generated method stub					
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub				
			}
    	};
    	
    	
  		// Hier kann eingestellt werden wie oft die GPS daten abgerufen werden sollen.
  		// bzw. bei welcher Positionsänderung. 
    	LocationProvider provider = lm.getProvider("gps");
    	lm.requestLocationUpdates("gps",
    	        1000, // 1min
    	        (float) (10),   // 10m
    	        locationListener);
		
	}

}
