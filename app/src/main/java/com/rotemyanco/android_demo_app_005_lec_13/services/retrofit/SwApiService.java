package com.rotemyanco.android_demo_app_005_lec_13.services.retrofit;
import com.rotemyanco.android_demo_app_005_lec_13.models.responses.VehicleResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface SwApiService {

    static SwApiService create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(SwApiService.class);
    }

    @GET("vehicles")
    Call<VehicleResponse> getVehicleResponse();

    @GET("vehicles")
    Call<VehicleResponse> getVehicleResponse(@Query("page") int page);

    @GET("vehicles")
    Call<VehicleResponse> getVehicleResponse(@Query("format") String format);

    @GET("vehicles")
    Call<VehicleResponse> getVehicleResponse(@Query("page") int page, @Query("format") String format);



}
