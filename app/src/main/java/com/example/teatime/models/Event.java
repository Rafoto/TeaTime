package com.example.teatime.models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

import java.io.Serializable;
import java.util.Date;

@ParseClassName("Event")
public class Event extends ParseObject implements Serializable {
    public static final String KEY_DESCRIPTION = "description";
    public static final String NAME = "name";
    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";
    public static final String CLASS = "class";
    public static final String LOCATION = "location";


    public String getName() {
        return getString(NAME);
    }

    public void setName(String name) {
        put(NAME, name);
    }

    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public ParseGeoPoint getLocation() {
        return getParseGeoPoint(LOCATION);
    }

    public void setLocation(ParseGeoPoint location) {
        put(KEY_DESCRIPTION, location);
    }

    public String getClassName() {
        return getString(CLASS);
    }

    public void setClassName(String description) {
        put(CLASS, description);
    }

    public Date getStartTime() {
        return getDate(START_TIME);
    }

    public void setStartTime(Date date) {
        put(START_TIME, date);
    }

    public Date getEndTime() {
        return getDate(END_TIME);
    }

    public void setEndTime(Date date) {
        put(END_TIME, date);
    }

}
