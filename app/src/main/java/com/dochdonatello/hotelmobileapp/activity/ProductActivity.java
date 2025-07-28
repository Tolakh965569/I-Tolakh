package com.dochdonatello.hotelmobileapp.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dochdonatello.hotelmobileapp.R;
import com.dochdonatello.hotelmobileapp.adapter.ProductAdapter;
import com.dochdonatello.hotelmobileapp.data.remote.api.ApiClient;
import com.dochdonatello.hotelmobileapp.data.remote.api.ApiInterface;
import com.dochdonatello.hotelmobileapp.data.remote.models.response.ProductResponse;
import com.dochdonatello.hotelmobileapp.data.remote.models.response.ProductsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView recyclerViewProduct;

    private ApiInterface apiInterface;

    private ProductAdapter productAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<ProductsItem> productsItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerViewProduct = findViewById(R.id.recyclerViewProduct);
        getData();
    }
    private void getData(){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getAllProduct().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response.isSuccessful()) {
                    assert response.body() != null;
                    if(!response.body().getProducts().isEmpty()){
//                        productsItemList = response.body();
                        // Set Layout Manager
                        layoutManager = new GridLayoutManager(ProductActivity.this,1);
                        recyclerViewProduct.setLayoutManager(layoutManager);
                        // Set to adapter
                        productAdapter = new ProductAdapter(ProductActivity.this,response.body().getProducts());
                        recyclerViewProduct.setAdapter(productAdapter);
                    }
                }
            }
            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Toast.makeText(ProductActivity.this,""+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}