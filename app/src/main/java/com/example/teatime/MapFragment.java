package com.example.teatime;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Application;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teatime.models.Event;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.Parse;


import java.util.ArrayList;
import java.util.List;


public class MapFragment extends Fragment {
//    private static String ARG_MEMBERS = "members";
//    private List<Membership> members;

    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance() {

        Bundle args = new Bundle();
//        args.putParcelableArrayList(ARG_MEMBERS, (ArrayList) members);
        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            this.members = getArguments().getParcelableArrayList(ARG_MEMBERS);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        com.google.android.gms.maps.MapFragment mapFragment = com.google.android.gms.maps.MapFragment.newInstance();  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                mMap.clear(); //clear old markers
                //Create marker for current user on the map

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(members.get(0).getLocation().getLatitude(), members.get(0).getLocation().getLongitude()))
                        .title("You")
                        .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.cake)));
                //Query all events
                ParseQuery<Event> query = ParseQuery.getQuery("Event");
                query.findInBackground(new FindCallback<Event>() {
                    public void done(List<Event> eventsList, ParseException e) {
                        if (e == null) {
                            for (Event event : eventsList){

                            }
                        } else {
                            Log.e("events", "Error: " + e.getMessage());
                        }
                    }
                });
//                CameraPosition googlePlex = CameraPosition.builder()
//                        .target(new LatLng(members.get(0).getLocation().getLatitude(), members.get(0).getLocation().getLongitude()))
//                        .zoom(10)
//                        .bearing(0)
//                        .tilt(45)
//                        .build();
//
//                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);
//
//                mMap.addMarker(new MarkerOptions()
////                        .position(new LatLng(members.get(0).getLocation().getLatitude(), members.get(0).getLocation().getLongitude()))
////                        .title("You")
////                        .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.cake)));
////                for (int i = 1; i < members.size(); i++) {
////                    mMap.addMarker(new MarkerOptions()
////                            .position(new LatLng(members.get(i).getLocation().getLatitude(), members.get(i).getLocation().getLongitude()))
////                            .title("Group Member"));
//                }
            }
        });
        return rootView;
    }


    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
