package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.control;

import org.json.JSONException;
import org.json.JSONObject;

import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Location;
import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Route;

public class RouteController {
	private static RouteController instance;
	private Route activeRoute;
	
	
	
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
	
	@Deprecated
	public void getDefaultRoute(){		
		String[] hintsA = {"Am Wasser liegt ein See.",
						   "Die Sonne scheint auch nachts.",
						   "Nachts ists kälter als draußen.",
						   "Gestern war auch schön."};
		Location a = new Location(0, 0, hintsA, "Hinweis 1", "");
		
		String[] hintsB = {"Heute Trinken",
						   "Morgen Sterben",
						   "Wein her!"};
		Location b = new Location(1, 1, hintsB, "Hinweis 2", "");
		
		activeRoute = new Route(2);
		activeRoute.addLocation(a, 0);
		activeRoute.addLocation(b, 1);
	}

	public Route getActiveRoute(){
		return activeRoute;
	}
	
	public void setActiveRoute(Route route){
		this.activeRoute = route;
	}
	
	public void createRoute(JSONObject json){
		int nrOfLocs;
<<<<<<< HEAD
		
		
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

=======
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
>>>>>>> be16e16bc37c2adfd3339f67bd4242f67b2a8c81
	}
	
	public void addLocation(JSONObject json){
		try {
			String routeID = json.getString("routeID");
			int currentLoc = json.getInt("currentLoc");
			
<<<<<<< HEAD
			if(!activeRoute.getId().equals(routeID) ){
				return;
			}
			
			//|| Route.locCounter+1!=currentLoc
			
=======
			if(!activeRoute.getId().equals(routeID) || Route.locCounter+1!=currentLoc){
				return;
			}
			
>>>>>>> be16e16bc37c2adfd3339f67bd4242f67b2a8c81
			String hintName = json.getString("hintName");
	
							//abkürzung für: if "hint0" ==null {""} else { get("hint0")}
			String hint0 = json.getString("hint0")==null?"":json.getString("hint0");
			String hint1 = json.getString("hint1")==null?"":json.getString("hint1");
			String hint2 = json.getString("hint2")==null?"":json.getString("hint2");
			String hint3 = json.getString("hint3")==null?"":json.getString("hint3");
			String hint4 = json.getString("hint4")==null?"":json.getString("hint4");
			
			long latitude = json.getLong("latitude");
			long longitude = json.getLong("longitude");
			
			String url = json.getString("imgURL");
			
			String[] hints = {hint0,hint1,hint2,hint3,hint4};
			
<<<<<<< HEAD
			
			Location loc = null;		
			
			if(currentLoc >= Route.locCounter){
				 loc = new Location(latitude, longitude, hints, hintName, url);
				 activeRoute.addLocation(loc, currentLoc);
				 Route.locCounter++;
			}
			else {
				loc = activeRoute.getLocation(currentLoc);
			}
			
			
			
			
=======
			Location loc = new Location(latitude, longitude, hints, hintName, url);
			
			activeRoute.addLocation(loc, currentLoc);
			Route.locCounter++;
>>>>>>> be16e16bc37c2adfd3339f67bd4242f67b2a8c81
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
