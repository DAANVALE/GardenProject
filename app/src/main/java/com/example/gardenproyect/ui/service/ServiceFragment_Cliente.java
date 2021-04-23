package com.example.gardenproyect.ui.service;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.gardenproyect.R;
import com.example.gardenproyect.ui.home.HomeViewModel_Cliente;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class ServiceFragment_Cliente extends Fragment implements OnMapReadyCallback{

    private ServiceViewModel_Cliente ServiceViewModelCliente;

    GoogleMap mGoogleMap;
    MapView mMapView;
    View root;
    private static final int LOCATION_REQUEST = 500;

    private TextView TVDate;
    private TextView TVHour;
    private Button btnDate;
    private Button btnHour;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private TimePickerDialog.OnTimeSetListener timeSetListener;

    MaterialButton logoutButton;

    private EditText mETMensaje;
    private Button mBtnCrearDatos;
    private DatabaseReference mDataBase;

    Button btnUbicacionActual;
    private FusedLocationProviderClient ubicacion;
    FirebaseDatabase database;
    DatabaseReference refubicacion;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ServiceViewModelCliente =
                ViewModelProviders.of(this).get(ServiceViewModel_Cliente.class);
        root = inflater.inflate(R.layout.fragment_service_cliente, container, false);

        btnDate = root.findViewById(R.id.btnDate);
        TVDate = root.findViewById(R.id.TVDate);
        btnHour = root.findViewById(R.id.btnHour);
        TVHour = root.findViewById(R.id.TVHour);


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog, dateSetListener, year, month, day);

                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: " + dayOfMonth + "/" + month + "/" + year);

                String date = dayOfMonth + "/" + month + "/" + year;
                TVDate.setText(date);

            }
        };

        btnHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minutes = cal.get(Calendar.MINUTE);

                TimePickerDialog dialog = new TimePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog, timeSetListener, hour, minutes, false);

                dialog.show();
            }
        });

        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d(TAG, "onTimeSet: hh:mm" + hourOfDay + ":" + minute);

                String time = hourOfDay + ":" + minute;
                TVHour.setText(time);

            }
        };

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnTypeService = view.findViewById(R.id.btnAgregarTipoServicio);
        logoutButton = view.findViewById(R.id.logoutButton);
        mETMensaje = view.findViewById(R.id.ETMensaje);
        mBtnCrearDatos = view.findViewById(R.id.btnCrearDatos);
        TVDate = view.findViewById(R.id.TVDate);
        TVHour = view.findViewById(R.id.TVHour);
        mDataBase = FirebaseDatabase.getInstance().getReference();
        btnUbicacionActual = view.findViewById(R.id.btnUbicacionActual);

        database = FirebaseDatabase.getInstance();
        refubicacion = database.getReference("ubicacion");

        mMapView = (MapView) root.findViewById(R.id.map);

        btnTypeService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.typeServiceFragment_Cliente);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Navigation.findNavController(v).navigate(R.id.loginScreen);
            }
        });

        mBtnCrearDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = mETMensaje.getText().toString();
                String fecha = TVDate.getText().toString();
                String hora = TVHour.getText().toString();
                Map<String, Object> usuarioMap = new HashMap<>();
                usuarioMap.put("nombre", "giovanni");
                usuarioMap.put("apellido", "vega");
                usuarioMap.put("edad", 19);
                usuarioMap.put("texto", texto);
                usuarioMap.put("fecha", fecha);
                usuarioMap.put("hora", hora);
                mDataBase.child("Usuarios").push().setValue(usuarioMap);
            }
        });

        btnUbicacionActual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dameubicacion();
            }
        });

        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }

    }

    private void dameubicacion() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getActivity(), "Permiso aceptado", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
            }, 1);
        }

        ubicacion = LocationServices.getFusedLocationProviderClient(getActivity());

        ubicacion.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    Double latitud = location.getLatitude();
                    Double longitud = location.getLongitude();

                    UbicacionActl ubi = new UbicacionActl(latitud, longitud);
                    refubicacion.push().setValue(ubi);

                    Toast.makeText(getActivity(), "Ubicacion agregada", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mGoogleMap.setMyLocationEnabled(true);

        marcadores(googleMap);
    }

    private void marcadores(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(new LatLng(20.6648312,-103.2086447)).title("Casa").snippet("Aqui haciendo el proyecto"));

        CameraPosition Casa = CameraPosition.builder().target(new LatLng(20.6648312,-103.2086447)).zoom(16).bearing(0).tilt(45).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Casa));
    }

}