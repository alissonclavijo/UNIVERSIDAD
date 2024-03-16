package ec.edu.taller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    //objetos
    GoogleMap gMap;
    FrameLayout map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //mapeo
        map=findViewById(R.id.map);
        //obtiene la referencia del fragmento del mapa desde el dise;o de la actividad
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.gMap=googleMap;
        LatLng mapEcuador=new LatLng(1.8321, 78.1834);
        this.gMap.addMarker(new MarkerOptions().position(mapEcuador).title("Marker Ecuador"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapEcuador));




    }
}