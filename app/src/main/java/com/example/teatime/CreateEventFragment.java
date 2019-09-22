package com.example.teatime;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.teatime.models.Event;
import com.example.teatime.models.Location;
import com.google.android.material.textfield.TextInputEditText;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;


public class CreateEventFragment extends Fragment {
    TextInputEditText etName;
    TextInputEditText etDescription;
    Spinner spinnerClass;
    Spinner spinnerLocation;
    Button btnCreateEvent;
    Button btnCreateTAEvent;

    public CreateEventFragment() {
        // Required empty public constructor
    }

    public static CreateEventFragment newInstance(String param1, String param2) {
        CreateEventFragment fragment = new CreateEventFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etDescription = view.findViewById(R.id.etDescription);
        etName = view.findViewById(R.id.etName);
        spinnerClass = view.findViewById(R.id.spinnerClass);
        spinnerLocation = view.findViewById(R.id.spinnerLocation);
        btnCreateEvent = view.findViewById(R.id.btnCreateEvent);
        btnCreateTAEvent = view.findViewById(R.id.btnCreateTAEvent);

        ArrayAdapter classAdapter = ArrayAdapter.createFromResource(getContext(), R.array.class_array, R.layout.spinner_layout);
        spinnerClass.setAdapter(classAdapter);
        final List<Location> locationList = Location.getAllLocationObjects();
        final List<String> locationNameList = new ArrayList<>();
        for (Location location : locationList) {
            locationNameList.add(location.getName());
        }
        ArrayAdapter locationAdapter = ArrayAdapter.createFromResource(getContext(), R.array.location_array, R.layout.spinner_layout);
        spinnerLocation.setAdapter(locationAdapter);

        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = new Event();
                event.setClassName(spinnerClass.getSelectedItem().toString());
                event.setDescription(etDescription.getText().toString());
                event.setName(etDescription.getText().toString());
                event.setInstructor(false);
                int locationIndex = locationNameList.indexOf(spinnerLocation.getSelectedItem().toString());
                event.setLocation(new ParseGeoPoint(locationList.get(locationIndex).getLatitude(), locationList.get(locationIndex).getLongitude()));
                event.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.flContent, MapFragment.newInstance()).commit();

                        }
                    }
                });
            }
        });
        btnCreateTAEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = new Event();
                event.setClassName(spinnerClass.getSelectedItem().toString());
                event.setDescription(etDescription.getText().toString());
                event.setName(etDescription.getText().toString());
                event.setInstructor(true);
                int locationIndex = locationNameList.indexOf(spinnerLocation.getSelectedItem().toString());
                event.setLocation(new ParseGeoPoint(locationList.get(locationIndex).getLatitude(), locationList.get(locationIndex).getLongitude()));
                event.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.flContent, MapFragment.newInstance()).commit();
                        }
                    }
                });
            }
        });
    }

    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
