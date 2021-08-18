package com.example.earth911apiwork;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;

import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;
import org.json.JSONObject;


public class FirstFragment extends Fragment {

    public static double currentLat = 0;
    public static double currentLong = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                MainActivity x = new MainActivity();
//                Location currentLocation = x.getCurrentFusedLocation();
//
//                double currentLat = currentLocation.getLatitude();
//                double currentLong = currentLocation.getLongitude();



//                Snackbar.make(view, "LAT: " + currentLat + " , LONG: " + currentLong, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();


                String url = "https://api.earth911.com/earth911.searchLocations";
                AsyncHttpClient earth911req = new AsyncHttpClient();
                RequestParams earthParams = new RequestParams();
                earthParams.put("api_key", "9f8e452085d40bad");
                earthParams.put("latitude", "41.993190");
                earthParams.put("longitude", "-88.068170");
                earthParams.put("material_id", "63");
                earth911req.get(url, earthParams, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                        // Handle resulting parsed JSON response here
//                        Snackbar.make(view, "MF IT WORKED", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();

                        JSONObject res = new JSONObject(response);
                        System.out.println(response);
                    }
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                    }
                });


//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

}