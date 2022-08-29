package com.rotemyanco.android_demo_app_005_lec_13.ui.home;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.rotemyanco.android_demo_app_005_lec_13.models.Vehicle;
import com.rotemyanco.android_demo_app_005_lec_13.repos.SwApiRepo;
import com.rotemyanco.android_demo_app_005_lec_13.services.listeners.rdbResponseListener;
import java.util.List;






public class HomeViewModel extends AndroidViewModel {


    private MutableLiveData<List<Vehicle>> vehicleListLivedata;
    private MutableLiveData<Vehicle> vehicleLiveData;
    private MutableLiveData<List<Vehicle>> localDBVehicleListLiveData;


    public HomeViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Vehicle>> getVehicleList() {
        if (vehicleListLivedata == null) {
            vehicleListLivedata = new MutableLiveData<>();
        }
        SwApiRepo.getInstance(getApplication().getApplicationContext()).getVehicleListResponse(new rdbResponseListener() {
            @Override
            public void onVehicleResponseSuccess(List<Vehicle> vehicleList) {
                vehicleListLivedata.postValue(vehicleList);
            }

            @Override
            public void onVehicleResponseFailure(String error) {

            }
        });
        return vehicleListLivedata;
    }

    public LiveData<List<Vehicle>> getLocalDBVehicleList() {
        return SwApiRepo.getInstance(getApplication().getApplicationContext()).getLocalDBVehicleList();
    }

    public LiveData<Vehicle> getLocalDBVehicleById(int id) {
        return SwApiRepo.getInstance(getApplication().getApplicationContext()).getLocalDBVehicleById(id);
    }

    public void upsertLocal(Vehicle ...vehicle) {
        SwApiRepo.getInstance(getApplication().getApplicationContext()).upsertVehicleLocalDB(vehicle);
    }

    public void deleteLocal(Vehicle vehicle) {
        SwApiRepo.getInstance(getApplication().getApplicationContext()).deleteVehicleLocalDB(vehicle);
    }

    public void deleteLocalById(int id) {
        SwApiRepo.getInstance(getApplication().getApplicationContext()).deleteVehicleByIdLocalDB(id);
    }

}































//        if (localDBVehicleListLiveData == null) {
//            localDBVehicleListLiveData = new MutableLiveData<>();
//        }
//        SwApiRepo.getInstance(getApplication().getApplicationContext()).getLocalDBVehicleList();




















//    public LiveData<List<Vehicle>> getVehicleList() {
//        List<Vehicle> vehicleList = new ArrayList<>();
//        vehicleListLivedata.postValue(vehicleList);
//
//        return vehicleListLivedata;
//    }
//
//    public LiveData<Vehicle> getVehicle() {
//        Vehicle vehicle = new Vehicle.Builder().build();
//        vehicleLiveData.postValue(vehicle);
//
//        return vehicleLiveData;
//    }
