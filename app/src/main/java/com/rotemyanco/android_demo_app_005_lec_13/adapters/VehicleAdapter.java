package com.rotemyanco.android_demo_app_005_lec_13.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.rotemyanco.android_demo_app_005_lec_13.R;
import com.rotemyanco.android_demo_app_005_lec_13.models.Vehicle;
import java.util.List;


public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleVH> {

    private List<Vehicle> vehicleList;
    private ItemClickListener mItemClickListener;


    public VehicleAdapter(List<Vehicle> vehicleList, ItemClickListener itemClickListener) {
        this.vehicleList = vehicleList;
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public VehicleVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VehicleVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleVH holder, int position) {

        Vehicle vehicle = vehicleList.get(position);

        holder.tvName.setText(vehicle.getName());
        holder.tvModel.setText(vehicle.getModel());
        holder.tvCost.setText(vehicle.getCost());

//        holder.cvVehicleRow.setOnClickListener(v -> {
//            // navigate to profile fragment/vehicle fragment
//        });

        holder.itemView.setOnClickListener(view -> {
            mItemClickListener.onItemClick(vehicle);
        });

    }

    @Override
    public int getItemCount() {
        if (vehicleList == null) {
            return 0;
        }
        return vehicleList.size();
    }

    public interface ItemClickListener {
        void onItemClick(Vehicle vehicle);
    }

    static class VehicleVH extends RecyclerView.ViewHolder {

        CardView cvVehicleRow;
        TextView tvName;
        TextView tvModel;
        TextView tvCost;


        public VehicleVH(@NonNull View itemView) {
            super(itemView);

            cvVehicleRow = itemView.findViewById(R.id.cv_vehicle_row);
            tvName = itemView.findViewById(R.id.tv_name_vehicle_row);
            tvModel = itemView.findViewById(R.id.tv_model_vehicle_row);
            tvCost = itemView.findViewById(R.id.tv_cost_vehicle_row);

        }
    }
}
