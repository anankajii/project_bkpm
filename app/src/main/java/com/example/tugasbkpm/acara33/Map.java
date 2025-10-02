package com.example.tugasbkpm.acara33;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.example.tugasbkpm.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara33_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this); // Load map async
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng boston = new LatLng(42.3601, -71.0589);

        mMap.addMarker(new MarkerOptions()
                .position(boston)
                .title("Boston, Mass")
                );

        mMap.getUiSettings().setZoomControlsEnabled(true);


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(boston, 15));
    }
}
