package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.control;

import org.json.JSONException;
import org.json.JSONObject;

import android.R;
import android.R.drawable;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.RouteActivity;
import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Location;
import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Route;

public class RouteController {
	private static RouteController instance;
	private Route activeRoute;
	private boolean isEndLoc = false;
	private Location endLoc;
	
	
	public static RouteController generateRouteController(int nrOfRoutes){
		instance = new RouteController();
		return instance;
	}
		
	public static RouteController getRouteController(){
		if(instance==null){
			instance = new RouteController();
		}
		return instance;
	}
	
	private RouteController(){
		//getDefaultRoute();

	}

	public Route getActiveRoute(){
		return activeRoute;
	}
	
	public void setActiveRoute(Route route){
		this.activeRoute = route;
	}
	
	public void createRoute(JSONObject json){
		int nrOfLocs;

		try {
			nrOfLocs = json.getInt("totalLocs");
			activeRoute = new Route(nrOfLocs);
		
			String routeName = json.getString("routeName");
			String routeID = json.getString("routeID");
			
			activeRoute.setId(routeID);
			activeRoute.setName(routeName);
			
			addLocation(json);
			
			Route.locCounter = 0;
		} catch (JSONException e) {
			e.printStackTrace();
		}

		
		
		try {
		
			//route nur erstellen wenn keine vorhanden ist oder eine neue route gescannt wurde.  
			if (activeRoute == null || !activeRoute.getId().equals(json.getString("routeID"))){				
				
					nrOfLocs = json.getInt("totalLocs");
					activeRoute = new Route(nrOfLocs);
				
					String routeName = json.getString("routeName");
					String routeID = json.getString("routeID");
					
					activeRoute.setId(routeID);
					activeRoute.setName(routeName);
					
					addLocation(json);
					
					Route.locCounter = 0;
			}
		} catch (JSONException e) {
				e.printStackTrace();
			
				
		}


	}
	
	public void addLocation(JSONObject json){
		try {
			String routeID = json.getString("routeID");
			int currentLoc = json.getInt("currentLoc");
			

			if(!activeRoute.getId().equals(routeID) ){
				return;
			}
			
			String hintName = json.getString("hintName");
	
							//abkürzung für: if "hint0" ==null {""} else { get("hint0")}
			String hint0 = json.getString("hint0")==null?"":json.getString("hint0");
			String hint1 = json.getString("hint1")==null?"":json.getString("hint1");
			String hint2 = json.getString("hint2")==null?"":json.getString("hint2");
			String hint3 = json.getString("hint3")==null?"":json.getString("hint3");
			String hint4 = json.getString("hint4")==null?"":json.getString("hint4");
			
			double latitude = json.getDouble("latitude");
			double longitude = json.getDouble("longitude");
			
			String url = json.getString("imgURL");
			
			String[] hints = {hint0,hint1,hint2,hint3,hint4};
			

			Location loc = new Location(latitude, longitude, hints, hintName, url);

			if(currentLoc == json.getInt("totalLocs")){
				//XXX: Endcase
				activeRoute.setIsWardSolved(Route.locCounter);
				endLoc = new Location(latitude, longitude, hints, hintName, url);
				isEndLoc = true;
				return;
			}
			
			if(currentLoc >= Route.locCounter){
				 loc = new Location(latitude, longitude, hints, hintName, url);
				 activeRoute.addLocation(loc, currentLoc);
				 if(currentLoc != 1){
					 activeRoute.setIsWardSolved(Route.locCounter);					 
				 }
				 Route.locCounter++;
			}
			else {
				loc = activeRoute.getLocation(currentLoc);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Location getLocation(int i){
		return (!isEndLoc || i <activeRoute.getLength())?activeRoute.getLocation(i):(endLoc!=null?endLoc:null);
	}
	
	public Location getCurrendLocation(){
		return activeRoute.getCurrendLocation();
	}
	
	public Bitmap getThumb(int i){
		if(activeRoute.getIsWardSolved(i)){
			return getLocation(i).getThumb();
		}

		//Bitmap bit = BitmapFactory.decodeFile("img/search.png");
		return null;
		
		
	}
}
