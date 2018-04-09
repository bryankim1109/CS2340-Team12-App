package edu.gatech.cs2340.team12.cs2340_team12_app.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import edu.gatech.cs2340.team12.cs2340_team12_app.R;
import edu.gatech.cs2340.team12.cs2340_team12_app.models.Shelter;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent intent = getIntent();
        Iterable<Shelter> filteredList = (List<Shelter>)intent
                .getSerializableExtra("ShelterList");
        // Add a marker in Sydney and move the camera
        for(Shelter s : filteredList) {
            LatLng shelterPos = new LatLng(Double.parseDouble(s.getLatitude()),
                    Double.parseDouble(s.getLongitude()));
            googleMap.addMarker(new MarkerOptions().position(shelterPos).title(s.getShelterName())
                    .snippet(s.getPhoneNumber()));
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(33.749, -84.388),
                11));
    }


    public static Intent makeIntent(Context context) {
        return new Intent(context, MapsActivity.class);
    }
}
