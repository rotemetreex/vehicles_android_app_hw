package com.rotemyanco.android_demo_app_005_lec_13.db;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.rotemyanco.android_demo_app_005_lec_13.models.Vehicle;





@Database(entities = {Vehicle.class}, version = 1)
public abstract class VehicleDB extends RoomDatabase {


    // return Vehicle DAO
    public abstract VehicleDAO getVehicleDAO();



    public static VehicleDB create(Context context) {
        return Room.databaseBuilder(context, VehicleDB.class, "Local_Vehicle_DB")
                // FOR TESTING ONLY!!
//                .allowMainThreadQueries()
                .build();
    }

}
