package com.dochdonatello.hotelmobileapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dochdonatello.hotelmobileapp.R;
import com.dochdonatello.hotelmobileapp.models.Hotel;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder>{
    private final Context context;
    private final List<Hotel> hotelList;
    private onClickListener onClickListener;
    public HotelAdapter(Context context, List<Hotel> hotelList, HotelAdapter.onClickListener onClickListener) {
        this.context = context;
        this.hotelList = hotelList;
        this.onClickListener = onClickListener;
    }
    public HotelAdapter(Context context, List<Hotel> hotelList) {
        this.context = context;
        this.hotelList = hotelList;
    }
    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotel_card_item_layout,null,false);
        return new HotelViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        Hotel hotel = hotelList.get(position);
        if(!hotel.getName().isEmpty())
        {
            holder.tvHotelName.setText(hotel.getName());
        }
        if(!hotel.getLocation().isEmpty())
        {
            holder.tvHotelLocation.setText("Location : "+hotel.getLocation());
        }
        if(!hotel.getDescription().isEmpty())
        {
            holder.tvHotelDescription.setText(hotel.getDescription());
        }
        holder.tvTotalShare.setText(""+hotel.getTotalShare());
        holder.tvTotalView.setText(""+hotel.getTotalView());
        if(!hotel.getImageUrl().isEmpty())
        {
            Glide.with(context).load(hotel.getImageUrl()).into(holder.ivHotelImage);
        }
        holder.ivView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClickView(v, hotel);
            }
        });

    }
    @Override
    public int getItemCount() {
        return hotelList.size();
    }
    public static class HotelViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvHotelName,tvHotelLocation, tvHotelDescription, tvTotalView, tvTotalShare;
        ImageView ivHotelImage, ivShare, ivView;
        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHotelName = itemView.findViewById(R.id.tvHotelName);
            tvHotelLocation = itemView.findViewById(R.id.tvHotelLocation);
            tvHotelDescription = itemView.findViewById(R.id.tvHotelDescription);
            tvTotalShare = itemView.findViewById(R.id.tvHotelTotalShare);
            tvTotalView = itemView.findViewById(R.id.tvHotelTotalView);
            ivHotelImage = itemView.findViewById(R.id.ivHotelImage);
            ivShare = itemView.findViewById(R.id.ivShare);
            ivView = itemView.findViewById(R.id.ivView);
        }
    }
    public interface onClickListener
    {
        void onClickView(View view, Hotel data);
    }
}
