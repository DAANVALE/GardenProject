package com.example.gardenproyect.ui.service;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.gardenproyect.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.app.Activity.RESULT_OK;
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

    private Button mBtnCrearDatos;
    private DatabaseReference mDataBase;

    private FusedLocationProviderClient ubicacion;
    FirebaseDatabase database;
    DatabaseReference refubicacion;

    String dia = "Date";
    String hora = "Time";
    EditText editText;
    String Nombre_direccion, Coordenadas_ubicacion;


    boolean Busqueda_de_ubicacion = false;
    String lat, lon;

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
                dia = date;
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
                hora = time;
            }
        };

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnTypeService = view.findViewById(R.id.btnAgregarTipoServicio);
        final LinearLayout LinearTarj = view.findViewById(R.id.lyt_tarjeta);
        Button btn_tarjeta = view.findViewById(R.id.btntarj);
        Button btn_efectivo = view.findViewById(R.id.btnefec);

        mBtnCrearDatos = view.findViewById(R.id.btnCrearDatos);
        TVDate = view.findViewById(R.id.TVDate);
        TVHour = view.findViewById(R.id.TVHour);
        mDataBase = FirebaseDatabase.getInstance().getReference();

        database = FirebaseDatabase.getInstance();
        refubicacion = database.getReference("ubicacion");

        mMapView = (MapView) root.findViewById(R.id.map);

        editText = view.findViewById(R.id.edit_text);
        Places.initialize(getActivity(), "AIzaSyAdD7LnLkwWg--MB8qf0Ko7Cm_uIfv1vOc");

        btnTypeService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.typeServiceFragment_Cliente);
            }
        });

        btn_tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearTarj.setVisibility(View.VISIBLE);
            }
        });

        btn_efectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearTarj.setVisibility(View.GONE);
            }
        });

        mBtnCrearDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fechas = dia;
                String horas = hora;
                Map<String, Object> usuarioMap = new HashMap<>();
                usuarioMap.put("nombre", "giovanni");
                usuarioMap.put("apellido", "vega");
                usuarioMap.put("edad", 19);
                if (Busqueda_de_ubicacion == true) {
                    usuarioMap.put("nombre de dirección", Nombre_direccion);
                    usuarioMap.put("coordenadas de ubicacion", Coordenadas_ubicacion);
                }else{
                    usuarioMap.put("coordenada latitud", lat);
                    usuarioMap.put("coordenada longitud", lon);
                }
                usuarioMap.put("fecha", fechas);
                usuarioMap.put("hora", horas);
                mDataBase.child("Usuarios").push().setValue(usuarioMap);
            }
        });

        TVDate.setText(dia);
        TVHour.setText(hora);

        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }

        editText.setFocusable(false);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS,
                        Place.Field.LAT_LNG, Place.Field.NAME);

                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY
                        , fieldList).build(getActivity());

                startActivityForResult(intent, 100);

            }
        });

    }

    private void dameubicacion(final GoogleMap googleMap) {
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

                    lat = latitud.toString();
                    lon = longitud.toString();

                    Toast.makeText(getActivity(), "Ubicacion agregada", Toast.LENGTH_SHORT).show();

                    googleMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud)).title("Ubicación actual"));

                    CameraPosition Ubicación_actual = CameraPosition.builder().target(new LatLng(latitud, longitud)).zoom(16).bearing(0).tilt(45).build();

                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Ubicación_actual));
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

        dameubicacion(googleMap);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            Place place = Autocomplete.getPlaceFromIntent(data);
            editText.setText(place.getAddress());
            Nombre_direccion = place.getName();
            Coordenadas_ubicacion = String.valueOf(place.getLatLng());
            mGoogleMap.clear();
            mGoogleMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getName()));
            CameraPosition Ubi_buscada = CameraPosition.builder().target(place.getLatLng()).zoom(16).bearing(0).tilt(45).build();
            mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Ubi_buscada));
            Busqueda_de_ubicacion = true;
        }else if (resultCode == AutocompleteActivity.RESULT_ERROR){
            Status status = Autocomplete.getStatusFromIntent(data);
            Toast.makeText(getActivity(), status.getStatusMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}