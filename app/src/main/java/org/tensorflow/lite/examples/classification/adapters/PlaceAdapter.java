package org.tensorflow.lite.examples.classification.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.models.Place;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder> {

    Context context;
    List<Place> mData;


    PlaceItemClickListener placeItemClickListener;

    public PlaceAdapter(Context context, List<Place> mData, PlaceItemClickListener listener) {
        this.context = context;
        this.mData = mData;
        placeItemClickListener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_place,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.txtName.setText(mData.get(position).getName());
        holder.imgPlace.setImageResource(mData.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private ImageView imgPlace;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=itemView.findViewById(R.id.txt_name);
            imgPlace=itemView.findViewById(R.id.img_place);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    placeItemClickListener.onPlaceClick(mData.get(getAdapterPosition()),imgPlace);
                }
            });

        }
    }
}
