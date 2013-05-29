package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.control;

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
	
	public void getDefaultRoute(){		
		String[] hintsA = {"Am Wasser liegt ein See.",
						   "Die Sonne scheint auch nachts.",
						   "Nachts ists kälter als draußen.",
						   "Gestern war auch schön."};
		Location a = new Location(0.0d, 0.0d, hintsA, "Hinweis 1");
		
		String[] hintsB = {"Heute Trinken",
						   "Morgen Sterben",
						   "Wein her!"};
		Location b = new Location(1.1d, 1.1d, hintsB, "Hinweis 2");
		
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
}
