package com.example.findmystuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class bluetoothDeviceAdapter extends
        RecyclerView.Adapter<bluetoothDeviceAdapter.deviceViewHolder> {
    private ArrayList<bluetoothDevice> deviceList;
    public bluetoothDeviceAdapter(ArrayList<bluetoothDevice> vehicleList) {
        this.deviceList = vehicleList;
    }
    public interface onItemClickListener {
        void onItemClick(int position);
    }
    private onItemClickListener mListener;
    public void setOnItemClickListener( onItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public deviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_device, parent, false);
        return new deviceViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull deviceViewHolder holder, int position) {
        bluetoothDevice device = deviceList.get(position);
        holder.deviceName.setText(device.getName());
        // Bind other vehicle data as needed
    }
    @Override
    public int getItemCount() {
        return deviceList.size();
    }
    public class deviceViewHolder extends RecyclerView.ViewHolder
    {

        TextView deviceName;
        public deviceViewHolder(@NonNull View itemView) {
            super(itemView);
            deviceName = itemView.findViewById(R.id.deviceNameText);
            itemView.setOnClickListener(v -> {
                if (mListener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
