package com.dochdonatello.hotelmobileapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.dochdonatello.hotelmobileapp.R;
import com.dochdonatello.hotelmobileapp.constant.Constants;
import com.dochdonatello.hotelmobileapp.models.Hotel;

public class HotelDetailActivity extends BaseActivity {
    private Hotel hotel;
    private TextView tvHotelName, tvHotelDesc,tvHotelLocation, tvHotelTotalView, tvHotelTotalShare;
    private ImageView ivHotelImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hotel_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        getDataHotel();
    }
    public void initView()
    {
        tvHotelDesc = findViewById(R.id.tvHotelDesc);
        tvHotelLocation = findViewById(R.id.tvHotelLocation);
        tvHotelName = findViewById(R.id.tvHotelName);
        tvHotelTotalShare = findViewById(R.id.tvTotalShare);
        tvHotelTotalView = findViewById(R.id.tvTotalView);
        ivHotelImage = findViewById(R.id.ivHotelImage);

    }
    public void getDataHotel()
    {
        hotel = new Hotel();
        Intent intent = getIntent();
        hotel.setId(intent.getIntExtra(Constants.HOTEL_ID,0));
        hotel.setName(intent.getStringExtra(Constants.HOTEL_NAME));
        hotel.setDescription(intent.getStringExtra(Constants.HOTEL_DESC));
        hotel.setLocation(intent.getStringExtra(Constants.HOTEL_LOCATION));
        hotel.setImageUrl(intent.getStringExtra(Constants.HOTEL_IMAGE));
        hotel.setTotalView(intent.getIntExtra(Constants.HOTEL_TOTAL_VIEW,0));
        hotel.setTotalShare(intent.getIntExtra(Constants.HOTEL_TOTAL_SHARE,0));

        tvHotelName.setText(hotel.getName());
        tvHotelDesc.setText(hotel.getDescription());
        tvHotelLocation.setText(hotel.getLocation());
        tvHotelTotalView.setText(""+hotel.getTotalView());
        tvHotelTotalShare.setText(""+hotel.getTotalShare());
        Glide.with(this).load(hotel.getImageUrl()).into(ivHotelImage);
    }
}