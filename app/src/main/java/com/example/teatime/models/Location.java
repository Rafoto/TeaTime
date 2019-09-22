package com.example.teatime.models;

import java.lang.reflect.Array;
import java.util.*;

public class Location {
    private String name;
    private double longitude;
    private double latitude;
    private static List<Location> allLocations = new ArrayList<Location>();

    public Location(double longitude, double latitude, String name){
        longitude = this.longitude;
        latitude = this.latitude;
        name = this.name;
    }

    public static void addElem(Location l){
        allLocations.add(l);
    }

    public static List<List<Double>> getAllLocations(){
        List<List<Double>> longAndLat = new ArrayList<>();
        for (Location loc : allLocations) {
            List<Double> tempList = new ArrayList<>();
            tempList.add(loc.longitude);
            tempList.add(loc.latitude);
            longAndLat.add(tempList);
        }
        return longAndLat;
    }

    public static void main(String[] args){
        List<Location> riceLocs = new ArrayList<>();
        riceLocs.add(new Location(29.721760,  -95.396695, "Jones College"));
        riceLocs.add(new Location(29.718143, -95.401692, "Rice Memorial Center"));
        riceLocs.add(new Location(29.714983, -95.399405, "Wiess College"));
        riceLocs.add(new Location(29.718294,  -95.399969, "Fondren Library"));
        for (Location loc : riceLocs){
            addElem(loc);
        }
        System.out.println("What the fuck");
    }
}
