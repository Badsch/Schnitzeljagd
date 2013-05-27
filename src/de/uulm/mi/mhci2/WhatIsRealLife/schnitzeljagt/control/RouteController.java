package de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.control;

import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Location;
import de.uulm.mi.mhci2.WhatIsRealLife.schnitzeljagt.resource.Route;

public class RouteController {
	private static RouteController instance;
	private Route[] routes;
	
	private int activeRoute = 0 ;
	
	
	public static RouteController generateRouteController(int nrOfRoutes){
		instance = new RouteController(nrOfRoutes);
		return instance;
	}
		
	public static RouteController getRouteController(){
		if(instance==null){
			instance = new RouteController(1);
		}
		return instance;
	}
	
	private RouteController(int nrOfRoutes){
		routes = new Route[nrOfRoutes];
		getDefaultRoute();
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
		
		routes[0] = new Route(2);
		routes[0].addLocation(a, 0);
		routes[0].addLocation(b, 1);
	}

	public Route getActiveRoute(){
		return routes[activeRoute];
	}
}
