package com.rotemyanco.android_demo_app_005_lec_13.services.listeners;

import com.rotemyanco.android_demo_app_005_lec_13.models.Vehicle;

import java.util.List;

public interface ldbResponseListener {

    void onLocalDBResponseSuccess(List<Vehicle> vehicleList);

    void onLocalDBResponseFailure(String error);
}
