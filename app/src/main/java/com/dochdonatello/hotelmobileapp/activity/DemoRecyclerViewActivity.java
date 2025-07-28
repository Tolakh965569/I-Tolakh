package com.dochdonatello.hotelmobileapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dochdonatello.hotelmobileapp.R;
import com.dochdonatello.hotelmobileapp.adapter.HotelAdapter;
import com.dochdonatello.hotelmobileapp.constant.Constants;
import com.dochdonatello.hotelmobileapp.models.Hotel;

import java.util.ArrayList;
import java.util.List;

public class DemoRecyclerViewActivity extends BaseActivity {
    private List<Hotel> hotelList;
    private HotelAdapter hotelAdapter;
    private RecyclerView recyclerViewHotel;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerViewHotel = findViewById(R.id.rcHotel);
        //Grid View or List View
        layoutManager = new GridLayoutManager(this,1);
        recyclerViewHotel.setLayoutManager(layoutManager);
        //Get All Data to List
        getData();
        //Set Data New Adapter
        hotelAdapter = new HotelAdapter(this, hotelList, new HotelAdapter.onClickListener() {
            @Override
            public void onClickView(View view, Hotel data) {
                openHotelDetail(data);
            }
        });
        //Set adapter to recycler view
        recyclerViewHotel.setAdapter(hotelAdapter);


    }
    private void openHotelDetail(Hotel data)
    {
        Intent intent = new Intent(this, HotelDetailActivity.class);
        intent.putExtra(Constants.HOTEL_ID, data.getId());
        intent.putExtra(Constants.HOTEL_NAME, data.getName());
        intent.putExtra(Constants.HOTEL_IMAGE, data.getImageUrl());
        intent.putExtra(Constants.HOTEL_DESC, data.getDescription());
        intent.putExtra(Constants.HOTEL_LOCATION, data.getLocation());
        intent.putExtra(Constants.HOTEL_TOTAL_VIEW, data.getTotalView());
        intent.putExtra(Constants.HOTEL_TOTAL_SHARE, data.getTotalShare());
        startActivity(intent);
    }
    private void getData()
    {
        //Phnom Penh
        hotelList = new ArrayList<>();
        Hotel sokhaHotel = new Hotel();
        sokhaHotel.setId(0);
        sokhaHotel.setName("Sokha Hotel");
        sokhaHotel.setDescription("Best Hotel in Phnom Penh.In essence, Sokha Hotels & Resorts aims to provide a luxurious and comprehensive hospitality experience, reflecting Cambodian pride and a commitment to memorable guest experiences." +
                "In essence, Sokha Hotels & Resorts aims to provide a luxurious and comprehensive hospitality experience, reflecting Cambodian pride and a commitment to memorable guest experiences." +
                "In essence, Sokha Hotels & Resorts aims to provide a luxurious and comprehensive hospitality experience, reflecting Cambodian pride and a commitment to memorable guest experiences." +
                "In essence, Sokha Hotels & Resorts aims to provide a luxurious and comprehensive hospitality experience, reflecting Cambodian pride and a commitment to memorable guest experiences." +
                "In essence, Sokha Hotels & Resorts aims to provide a luxurious and comprehensive hospitality experience, reflecting Cambodian pride and a commitment to memorable guest experiences." +
                "In essence, Sokha Hotels & Resorts aims to provide a luxurious and comprehensive hospitality experience, reflecting Cambodian pride and a commitment to memorable guest experiences." +
                "In essence, Sokha Hotels & Resorts aims to provide a luxurious and comprehensive hospitality experience, reflecting Cambodian pride and a commitment to memorable guest experiences.");
        sokhaHotel.setLocation("Phnom Penh, Cambodia.");
        sokhaHotel.setTotalShare(10000);
        sokhaHotel.setTotalView(20000);
        sokhaHotel.setImageUrl("https://www.1zoom.me/big2/48/228679-svetik.jpg");
        hotelList.add(sokhaHotel);

        //Kampong Som
//        hotelList = new ArrayList<>();
        Hotel sokhaHotelKPS = new Hotel();
        sokhaHotelKPS.setId(0);
        sokhaHotelKPS.setName("Sokha Hotel KPS");
        sokhaHotelKPS.setDescription("Best Hotel in Kampong Som.");
        sokhaHotelKPS.setLocation("Kampong Som, Cambodia.");
        sokhaHotelKPS.setTotalShare(35000);
        sokhaHotelKPS.setTotalView(25000);
        sokhaHotelKPS.setImageUrl("https://www.ezarri.com/media/uploads/noticias/general_/Ezarri_The-Lodge-Hotel_Porto_g.jpg");
        hotelList.add(sokhaHotelKPS);

        //Kampot
        Hotel sokhaHotelKP = new Hotel();
        sokhaHotelKP.setId(0);
        sokhaHotelKP.setName("Sokha Hotel KP");
        sokhaHotelKP.setDescription("Best Hotel in Kampot.");
        sokhaHotelKP.setLocation("Kampot, Cambodia.");
        sokhaHotelKP.setTotalShare(35300);
        sokhaHotelKP.setTotalView(35040);
        sokhaHotelKP.setImageUrl("https://www.hotelambiez.com/wp-content/uploads/2022/09/familysuite1-1600x1000.jpg");
        hotelList.add(sokhaHotelKP);

        //Siem Reap
        Hotel sokhaHotelSR = new Hotel();
        sokhaHotelSR.setId(0);
        sokhaHotelSR.setName("Sokha Hotel SR");
        sokhaHotelSR.setDescription("Best Hotel in Siem Reap.");
        sokhaHotelSR.setLocation("Siem Reap, Cambodia.");
        sokhaHotelSR.setTotalShare(32300);
        sokhaHotelSR.setTotalView(2040);
        sokhaHotelSR.setImageUrl("https://ae7.com/wp-content/uploads/2022/10/Danah_Bay_hotel-1600x1000.jpg");
        hotelList.add(sokhaHotelSR);

        //KPC
        Hotel sokhaHotelKPC = new Hotel();
        sokhaHotelKPC.setId(0);
        sokhaHotelKPC.setName("Sokha Hotel KPC");
        sokhaHotelKPC.setDescription("Best Hotel in Kampong Chhnang.");
        sokhaHotelKPC.setLocation("Kampong Chhnang, Cambodia.");
        sokhaHotelKPC.setTotalShare(23632);
        sokhaHotelKPC.setTotalView(2332);
        sokhaHotelKPC.setImageUrl("https://sokhahotels.com.kh/palace-siemreap/img/bg-slide/hotel-building-4.jpg");
        hotelList.add(sokhaHotelKPC);
    }
}