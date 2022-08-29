package com.rotemyanco.android_demo_app_005_lec_13.services.listeners;
import com.rotemyanco.android_demo_app_005_lec_13.models.Vehicle;
import java.util.List;




public interface rdbResponseListener {

    void onVehicleResponseSuccess(List<Vehicle> vehicleList);

    void onVehicleResponseFailure(String error);

}
