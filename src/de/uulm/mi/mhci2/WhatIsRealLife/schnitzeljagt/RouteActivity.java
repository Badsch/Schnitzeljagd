package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.qualcomm.QCARSamples.CloudRecognition.CloudReco;
import com.qualcomm.QCARSamples.CloudRecognition.R;

import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.control.RouteController;
import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Location;
import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Route;
///////

///


public class RouteActivity extends Activity implements
AdapterView.OnItemSelectedListener, ViewSwitcher.ViewFactory {
		
	private RouteController routeController;

	private Location activeLocation;
	
	private android.location.Location currentLocation;
	private android.location.Location targetLocation;
	private float distance = 0f;
	
	private LocationManager lm;
	
	private TextView locationTitle;
	private TextView routeTitle;
	private TextView hint0;
	private TextView hint1;
	private TextView hint2;
	private TextView hint3;
	private TextView hint4;
	
	private ImageSwitcher mSwitcher;
	

	//private Button startButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_route);
		
		routeController = RouteController.getRouteController();
		activeLocation = routeController.getCurrendLocation();		
		
		locationTitle =(TextView)findViewById(R.id.LocationTitle); 
		routeTitle =(TextView)findViewById(R.id.routeTitle1); 
		hint0 = (TextView) findViewById(R.id.locationHint1);
		hint1 = (TextView) findViewById(R.id.locationHint2);
		hint2 = (TextView) findViewById(R.id.locationHint3);
		hint3 = (TextView) findViewById(R.id.locationHint4);
		hint4 = (TextView) findViewById(R.id.locationHint5);
	
		setViewText(activeLocation);
		
		
		
		///// IMage Gallery
		//mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
        //mSwitcher.setFactory(this);
        //mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
        //        android.R.anim.fade_in));
        //mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
        //        android.R.anim.fade_out));
 
		mThumbIds = new Integer[routeController.getActiveRoute().getLength()];
		
        Gallery g = (Gallery) findViewById(R.id.gallery);
        g.setAdapter(new ImageAdapter(this));
        g.setOnItemSelectedListener(this);
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		activeLocation = routeController.getCurrendLocation();
		setViewText(activeLocation);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		activeLocation = routeController.getCurrendLocation();
		setViewText(activeLocation);
	}
	
	
	
	private void setViewText(){
		setViewText(activeLocation);
	}
	
	private void setViewText(Location location){
		//TODO fill me biatch!!!!!!
		
		Route route = routeController.getActiveRoute();

		if (location == null){
			routeTitle.setText(route.getName());
			locationTitle.setText("locked Postion");
			
			hint0.setText("");
			findViewById(R.id.ImageView01).setVisibility(View.GONE);
			hint1.setText("");
			findViewById(R.id.ImageView02).setVisibility(View.GONE);
			hint2.setText("");
			findViewById(R.id.ImageView03).setVisibility(View.GONE);
			hint3.setText("");
			findViewById(R.id.ImageView04).setVisibility(View.GONE);
			hint4.setText("");
			findViewById(R.id.ImageView05).setVisibility(View.GONE);

			
		}else{
			routeTitle.setText(route.getName());
			locationTitle.setText(location.getTitle());
			String[] hints = location.getHints();

			for(int i = 0;i<hints.length;i++){
				if(hints[i].length() > 1){
					switch(i){
						case 0:
							hint0.setText(hints[0]);
							findViewById(R.id.ImageView01).setVisibility(View.VISIBLE);
							break;
						case 1:
							hint1.setText(hints[1]);
							findViewById(R.id.ImageView02).setVisibility(View.VISIBLE);
							break;
						case 2:
							hint2.setText(hints[2]);
							findViewById(R.id.ImageView03).setVisibility(View.VISIBLE);
							break;
						case 3:
							hint3.setText(hints[3]);
							findViewById(R.id.ImageView04).setVisibility(View.VISIBLE);
							break;
						case 4:
							hint4.setText(hints[4]);
							findViewById(R.id.ImageView05).setVisibility(View.VISIBLE);
							break;
							
					}
				}else{
					switch(i){
						case 0:
							hint0.setText("");
							findViewById(R.id.ImageView01).setVisibility(View.GONE);
							break;
						case 1:
							hint1.setText("");
							findViewById(R.id.ImageView02).setVisibility(View.GONE);
							break;
						case 2:
							hint2.setText("");
							findViewById(R.id.ImageView03).setVisibility(View.GONE);
							break;
						case 3:
							hint3.setText("");
							findViewById(R.id.ImageView04).setVisibility(View.GONE);
							break;
						case 4:
							hint4.setText("");
							findViewById(R.id.ImageView05).setVisibility(View.GONE);
							break;
					}
				}
			}
		}
		
		


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
	
	public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
		
		
		Location loc = routeController.getLocation(position);
		setViewText(loc);
		//locationTitle.setText(String.valueOf(position));
        //mSwitcher.setImageResource(mImageIds[position]);
		
        //if (routeController.getActiveRoute().getLocation(position) == null || routeController.getActiveRoute().getLocation(position).getThumb() == null){
        	
        	//mSwitcher.setImageResource(R.drawable.locked);
        //}
        //else{
        	
       // 	Drawable d = new BitmapDrawable(getResources(),routeController.getActiveRoute().getLocation(position).getThumb());        
        	//mSwitcher.setImageDrawable(d);          	
        //} 
		
    }
 
    public void onNothingSelected(AdapterView<?> parent) {
    }
 
    public View makeView() {
        ImageView i = new ImageView(this);
        i.setBackgroundColor(0xFF000000);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
               
        
        return i;
    }
 

 
    public class ImageAdapter extends BaseAdapter {
        public ImageAdapter(Context c) {
            mContext = c;
        }
 
        public int getCount() {
            return mThumbIds.length;
        }
 
        public Object getItem(int position) {
            return position;
        }
 
        public long getItemId(int position) {
            return position;
        }
 
        @SuppressLint("NewApi")
		public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);
 
            //i.setImageResource(mThumbIds[position]);
            
            if (position == 0){
            	findViewById(R.id.arrow_l).setVisibility(View.INVISIBLE); 
            }
            else {
            	findViewById(R.id.arrow_l).setVisibility(View.VISIBLE); 
            }
            
            if (position == getCount()-1){
            	findViewById(R.id.arrow_r).setVisibility(View.INVISIBLE); 
            }
            else {
            	findViewById(R.id.arrow_r).setVisibility(View.VISIBLE); 
            }
           
            
            if (routeController.getLocation(position) == null || routeController.getLocation(position).getThumb() == null){
            	
            	i.setImageResource(R.drawable.locked);                
            }
            else{
            	if(routeController.getActiveRoute().getIsWardSolved(position)){
                	Bitmap b = routeController.getLocation(position).getThumb();

                	i.setImageBitmap(Bitmap.createScaledBitmap(b, 243, 333, false));
            	}else if(!routeController.getActiveRoute().getIsWardSolved(position)){
            		i.setImageResource(R.drawable.search); 
            	}else {
            		i.setImageResource(R.drawable.locked); 
            	}
            		
            	//routeController.getActiveRoute().getLocation(position).getThumb().getByteCount();
            	//i.setImageResource(routeController.getActiveRoute().getLocation(position).getThumb().getByteCount()); 
            	//i.setImageBitmap(routeController.getActiveRoute().getLocation(position).getThumb());
            	
            	//Drawable drawable =new BitmapDrawable(routeController.getActiveRoute().getLocation(position).getThumb());
            	//drawable.setB
            	//i.setImageDrawable(drawable);
            	
            	//i.setMinimumHeight(300);
            	//i.setScaleType(ScaleType.FIT_CENTER);
            	
            }       
            
            
           
           
            //i.setAdjustViewBounds(true);
            //i.setLayoutParams(new Gallery.LayoutParams(
            //        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            //i.setBackgroundResource(R.drawable.blueprint_vuforia);
            return i;
        }
 
        private Context mContext;
 
    }
    private Integer[] mThumbIds;
    //private Integer[] mThumbIds = {
    //        R.drawable.test, R.drawable.test2,
    //        R.drawable.test, R.drawable.test2};
 
    private Integer[] mImageIds = {
    		R.drawable.test, R.drawable.test2,
            R.drawable.test, R.drawable.test2};
 
}


