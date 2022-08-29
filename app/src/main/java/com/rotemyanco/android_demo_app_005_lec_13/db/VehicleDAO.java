package com.rotemyanco.android_demo_app_005_lec_13.db;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.rotemyanco.android_demo_app_005_lec_13.models.Vehicle;
import java.util.List;





@Dao
public interface VehicleDAO {



    @Query("SELECT * FROM vehicle")
    LiveData<List<Vehicle>> getAll();

    @Query("SELECT * FROM vehicle WHERE id = :id")
    LiveData<Vehicle> getVehicleById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upsertVehicle(Vehicle ...vehicle);

    @Delete
    void delete(Vehicle vehicle);

    @Query("DELETE FROM vehicle WHERE id = :id")
    void deleteById(int id);



}
