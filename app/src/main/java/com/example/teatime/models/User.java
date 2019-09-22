package com.example.teatime.models;

import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

import java.io.Serializable;
import java.util.Date;

public class User extends ParseObject implements Serializable {
    public static final String NAME = "name";
    public static final String USRNAME = "username";
    public static final String LOCATION = "location";


    public String getName() {
        return getString(NAME);
    }

    public void setName(String name) {
        put(NAME, name);
    }

    public String getUsername() {
        return getString(USRNAME);
    }

    public ParseGeoPoint getLocation() {
        return getParseGeoPoint(LOCATION);
    }

    public void setLocation(ParseGeoPoint location) {
        put(LOCATION, location);
    }
}
