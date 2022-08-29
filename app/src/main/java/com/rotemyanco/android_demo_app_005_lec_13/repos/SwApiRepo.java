package com.rotemyanco.android_demo_app_005_lec_13.repos;
import android.content.Context;

import androidx.lifecycle.LiveData;
import com.rotemyanco.android_demo_app_005_lec_13.db.VehicleDB;
import com.rotemyanco.android_demo_app_005_lec_13.models.Vehicle;
import com.rotemyanco.android_demo_app_005_lec_13.models.responses.VehicleResponse;
import com.rotemyanco.android_demo_app_005_lec_13.services.listeners.ldbResponseListener;
import com.rotemyanco.android_demo_app_005_lec_13.services.listeners.rdbResponseListener;
import com.rotemyanco.android_demo_app_005_lec_13.services.retrofit.SwApiService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;







public class SwApiRepo {


    private SwApiService retrofit;
    private static SwApiRepo swapiRepoInstance;
    private VehicleDB vehicleDB;


    private SwApiRepo(Context context) {
        retrofit = SwApiService.create();
        vehicleDB = VehicleDB.create(context);
    }

    public static SwApiRepo getInstance(Context context) {
        if (swapiRepoInstance == null) {
            swapiRepoInstance = new SwApiRepo(context);
        }
        return swapiRepoInstance;
    }



    // retrofit service - calls remote server and database (remote db)
    public void getVehicleListResponse(rdbResponseListener listener) {
        retrofit.getVehicleResponse().enqueue(new Callback<VehicleResponse>() {
            @Override
            public void onResponse(Call<VehicleResponse> call, Response<VehicleResponse> response) {
//                Log.d("------- SwApiRepo --------", "onResponse: "+response.body().getResults());
                listener.onVehicleResponseSuccess(response.body().getResults());

            }

            @Override
            public void onFailure(Call<VehicleResponse> call, Throwable t) {
//                Log.d("------- SwApiRepo --------", "onFailure: "+t.getMessage());
                listener.onVehicleResponseFailure(t.getMessage());
            }
        });
    }



    // Room db - gets the vehicle list from the local db (local db)
    public LiveData<List<Vehicle>> getLocalDBVehicleList() {
        return vehicleDB.getVehicleDAO().getAll();
    }

    public void getLocalDBVehicleList(ldbResponseListener ldbResponseListener) {
        ldbResponseListener.onLocalDBResponseSuccess(vehicleDB.getVehicleDAO().getAll().getValue());
//        Log.d("---------- SwApi Repo -----------", "getLocalDBVehicleList: "+vehicleDB.getVehicleDAO().getAll());
        ldbResponseListener.onLocalDBResponseFailure("error");
    }



    public LiveData<Vehicle> getLocalDBVehicleById(int id) {
        return vehicleDB.getVehicleDAO().getVehicleById(id);
    }

    public void upsertVehicleLocalDB(Vehicle ...vehicle) {
        vehicleDB.getVehicleDAO().upsertVehicle(vehicle);
    }

    public void deleteVehicleLocalDB(Vehicle vehicle) {
        vehicleDB.getVehicleDAO().delete(vehicle);
    }

    public void deleteVehicleByIdLocalDB(int id) {
        vehicleDB.getVehicleDAO().deleteById(id);
    }


}
