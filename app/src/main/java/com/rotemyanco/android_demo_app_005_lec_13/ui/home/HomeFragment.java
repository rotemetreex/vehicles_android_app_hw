package com.rotemyanco.android_demo_app_005_lec_13.ui.home;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.rotemyanco.android_demo_app_005_lec_13.LoginActivity;
import com.rotemyanco.android_demo_app_005_lec_13.R;
import com.rotemyanco.android_demo_app_005_lec_13.adapters.VehicleAdapter;
import com.rotemyanco.android_demo_app_005_lec_13.models.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private VehicleAdapter adapter;
    private RecyclerView rcvVehicles;
    private TextView tvSignOut;

    private List<Vehicle> remoteVehicleList;
    private List<Vehicle> localDBVehicleList;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        tvSignOut = v.findViewById(R.id.tv_signout_frag_home);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecycler(view);

        homeViewModel.getVehicleList().observe(getViewLifecycleOwner(), vehicles -> {
            Log.d("-------- Home Fragment ---------", "onViewCreated: get from ---->    web services\n" + vehicles.toString());

            // get the remote list and save it
            remoteVehicleList = new ArrayList<>();
            remoteVehicleList.addAll(vehicles);

            // update local db with the saved remote list
            localDBVehicleList = new ArrayList<>();
            localDBVehicleList.addAll(vehicles);

            Log.d("-------- Home Fragment ---------", "onViewCreated: get from ---->    local db\n" + localDBVehicleList);

        });


        tvSignOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            getActivity().finish();
            startActivity(new Intent(getContext(), LoginActivity.class));
        });







        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setName("mmmmmmmmmm");
        vehicle.setModel("mmmmmmmmmmmmm");
        vehicle.setCost("222222222222");
        homeViewModel.upsertLocal(vehicle);
    }

    private void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private void setUpRecycler(View view) {
        rcvVehicles = view.findViewById(R.id.rcv_vehicle_list_frag_home);
        adapter = new VehicleAdapter(localDBVehicleList, vehicle -> {
            Log.d("-------- Home Fragment ---------", "onViewCreated: "+vehicle.toString());
            showToast(vehicle +" Clicked!");
        });
        rcvVehicles.setAdapter(adapter);
        rcvVehicles.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}