package ru.sberbank.learning.samplemap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements ShopInfoHost {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        if (savedInstanceState == null) {
            ShopListFragment fragment = new ShopListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.first, fragment)
                    .commit();
        }
    }

    @Override
    public void displayShop(Address address) {
        BaseShopInfoFragment fragment
                = BaseShopInfoFragment.newInstance(address);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.second, fragment)
                .commit();
    }
}
