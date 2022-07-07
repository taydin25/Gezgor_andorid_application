package com.example.mdpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mdpro.databinding.ActivityMapsBinding;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity  implements OnMapReadyCallback  {

    static String cty;
    private Intent serviceIntent;
    private Button btn_msc;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ZoomControls zoom =(ZoomControls)findViewById(R.id.zoom);
        zoom.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });
        zoom.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });
        Button btn_fnd=(Button)findViewById(R.id.btn_find);
        EditText loc_edt=(EditText) findViewById(R.id.location);
        btn_msc=(Button)findViewById(R.id.msc);
        serviceIntent = new Intent(getApplicationContext(),MyService.class);
        //For Sound
        btn_msc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_msc.getText().equals("PLAY")){
                    btn_msc.setText("STOP");
                    startService(new Intent(getApplicationContext(),MyService.class));

                }
                else {
                    btn_msc.setText("PLAY");
                    stopService(new Intent(getApplicationContext(), MyService.class));
                }
            }
        });

        btn_fnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = loc_edt.getText().toString();//For find location Find button.
                //bu kısıma bak sonra 41:29
                if(!location.equals("") && location!=null )
                {
                        List<Address> addressList=null;
                        Geocoder geocoder = new Geocoder(MapsActivity.this);
                        try{
                          addressList=geocoder.getFromLocationName(location,1);
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        Address address=addressList.get(0);
                        LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                        mMap.clear();
                        mMap.addMarker(new MarkerOptions().position(latLng).title("This Location:"+location));
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                }
            }
        });
        //For MAP TYPE
        final Button btn_sal=(Button)findViewById(R.id.btn_sat);
        btn_sal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL)
                {
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    btn_sal.setText("HYBRID");
                }
                else if(mMap.getMapType() == GoogleMap.MAP_TYPE_HYBRID)
                {
                    mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    btn_sal.setText("TERRAIN");
                }
                else if(mMap.getMapType() == GoogleMap.MAP_TYPE_TERRAIN){
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    btn_sal.setText("SATELLITE");
                } else if(mMap.getMapType() == GoogleMap.MAP_TYPE_SATELLITE){
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    btn_sal.setText("NORMAL");
                }
            }
        });
/*
        Intent receiveIntent = this.getIntent();
        String P_places =receiveIntent.getStringExtra("Pretty_places");
        System.out.println("Pretty travel place is " +P_places);
        //&& P_places.equals("Ayasofya")
        if(P_places!= null  ){
            //Find beatiful travel places
            String location = P_places;//For find location
            System.out.println("***************************************"+location+"**********************************");

                List<Address> addressList=null;
                Geocoder geocoder = new Geocoder(MapsActivity.this);
                try{
                    addressList=geocoder.getFromLocationName(location,1);
                }catch (IOException e){
                    e.printStackTrace();
                }
                Address address=addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                System.out.println("*********************************************"+address.getLatitude());
                System.out.println("*********************************************"+address.getLongitude());
                //mMap.clear();
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title("This Location:"+location);
                mMap.addMarker(markerOptions);
            //  mMap.addMarker(new MarkerOptions().position(latLng).title("This Location:"+location));
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));


          /*  double Latitude=41.008469 ;
            double Longitude=28.980261;

            MarkerOptions markerOptions=new MarkerOptions();
            LatLng point = new LatLng(Latitude,Longitude);
            markerOptions.position(point);
            mMap.clear();
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(point,7));
            mMap.addMarker(markerOptions);
            LatLng latLng = new LatLng(Latitude,Longitude);
           // mMap.clear();
            mMap.addMarker(new MarkerOptions().position(latLng).title("This place is "+P_places));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
          //  mMap.clear();

        }*/

    }

    //Get address information
    public String getAddress(Context context, double lat, double lng) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            Address obj = addresses.get(0);

            String add =  obj.getAdminArea();//Get CITY NAME
            return add;
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Ankara, Turkey.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Firstly,Add a marker in Ankara and move the camera
        LatLng ankara = new LatLng(39.925533, 32.866287);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ankara,7f));
        //Calculate clicked Lat and lon
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {
                MarkerOptions markerOptions=new MarkerOptions();
                markerOptions.position(point);
                double lat = point.latitude;
                double lng = point.longitude;

                mMap.clear();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(point,7));
                mMap.addMarker(markerOptions);
                String city=getAddress(getApplicationContext(),lat,lng);
                System.out.println("sehir "+city);
                cty=city;
                Intent intent = new Intent(MapsActivity.this,places.class);
                intent.putExtra("city2",city);
                startActivity(intent);

            }
        });
        //Find location from places.java SHOW PLACES IN MAP
        Intent receiveIntent = this.getIntent();
        String P_places =receiveIntent.getStringExtra("Pretty_places");
        System.out.println("Pretty travel place is " +P_places);
        //&& P_places.equals("Ayasofya")
        if(P_places!= null  ) {
            //Find beatiful travel places
            String location = P_places;//For find location
            System.out.println("***************************************" + location + "**********************************");
            List<Address> addressList = null;
            Geocoder geocoder = new Geocoder(MapsActivity.this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            System.out.println("*********************************************" + address.getLatitude());
            System.out.println("*********************************************" + address.getLongitude());
            //mMap.clear();
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("This Location:" + location +" in " + cty );
            mMap.addMarker(markerOptions);
            //  mMap.addMarker(new MarkerOptions().position(latLng).title("This Location:"+location));
            //mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,80));
        }

    }

}