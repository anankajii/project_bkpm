package com.example.tugasbkpm.acara34;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.tugasbkpm.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final int REQ_PERM = 1001;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara34_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) mapFragment.getMapAsync(this);

        // inisialisasi LocationManager
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // hapus semua marker lama dan tambahkan marker baru di posisi klik
        mMap.setOnMapClickListener(latLng -> {
            mMap.clear(); // hapus marker sebelumnya (opsional)
            mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title("Marker di: " + latLng.latitude + ", " + latLng.longitude));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        });


        // aktifkan zoom control
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // cek izin lokasi
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);

            // tambahkan proximity alert


            // mulai monitoring perubahan lokasi
            startLocationUpdates();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQ_PERM);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_PERM) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                    startLocationUpdates();
                }
            } else {
                Toast.makeText(this, "Izin lokasi ditolak", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // method untuk menambahkan proximity alert
    @SuppressWarnings("deprecation")
    private void addProximityAlert(double lat, double lon) {
        float radius = 100f; // 100 meter
        long expiration = -1; // tidak kadaluarsa

        // Explicit intent ke BroadcastReceiver
        Intent intent = new Intent(this, ProximityReciver.class);

        PendingIntent pending = PendingIntent.getBroadcast(
                this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE
        );

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.addProximityAlert(lat, lon, radius, expiration, pending);
        }
    }


    // method untuk memonitor perubahan lokasi
    private void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            LocationListener locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    String msg = "Location Changed: "
                            + location.getLatitude() + ", "
                            + location.getLongitude();
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {}

                @Override
                public void onProviderEnabled(String provider) {}

                @Override
                public void onProviderDisabled(String provider) {}
            };

            // minta update lokasi dari GPS
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    90000,   // minimal interval waktu (ms)
                    100,      // minimal jarak (meter)
                    locationListener
            );
        }
    }
}
