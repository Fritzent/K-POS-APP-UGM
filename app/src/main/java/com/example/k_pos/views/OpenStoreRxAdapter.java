package com.example.k_pos.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.k_pos.R;

import java.util.List;

public class OpenStoreRxAdapter extends RecyclerView.Adapter<OpenStoreRxAdapter.ViewHolder>  {

    private LayoutInflater layoutInflater;
    private List<String> data;


    OpenStoreRxAdapter(Context context, List<String> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.open_store_list_location_store_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //bind the textview with data recevied here
        String titleStore = data.get(position);
        holder.textTitleNamaStore.setText(titleStore);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        TextView textNamaStore,textTitleNamaStore,textNomorTelepon,textKotaStore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNamaStore = itemView.findViewById(R.id.open_store_store_name_value);
            textTitleNamaStore = itemView.findViewById(R.id.txtUserStore);
            textKotaStore = itemView.findViewById(R.id.open_store_city_value) ;
            textNomorTelepon = itemView.findViewById(R.id.open_store_phone_number_value);
        }
    }
}
