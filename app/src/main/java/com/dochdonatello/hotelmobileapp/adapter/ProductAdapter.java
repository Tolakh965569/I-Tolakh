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
import com.dochdonatello.hotelmobileapp.data.remote.models.response.ProductsItem;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    // Data Member
    private Context context;
    private List<ProductsItem> productsItemList;
    // Constructor
    public ProductAdapter(Context context, List<ProductsItem> productsItemList) {
        this.context = context;
        this.productsItemList = productsItemList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_card_layout,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductsItem productsItem = productsItemList.get(position);
        if(!productsItem.getTitle().isBlank()){
            holder.tvProductName.setText(productsItem.getTitle());
        }
        if(!productsItem.getCategory().isBlank()){
            holder.tvCategoryName.setText("ប្រភេទទំនិញ : "+productsItem.getCategory().toUpperCase());
        }
        holder.tvProductPrice.setText("តម្លៃ : "+productsItem.getPrice()+"$");
        //khmer price
//        NumberFormat formatter = NumberFormat.getInstance(new Locale("km", "KH"));
//        double price = Double.parseDouble(productsItem.getPrice().toString());
//        holder.tvProductPrice.setText("តម្លៃ : " + (int)(price * 4010) + " ៛");
        Glide.with(context).load(productsItem.getThumbnail()).into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return productsItemList.size();
    }

    // Create View Holder

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private TextView tvProductName, tvCategoryName, tvProductPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            tvCategoryName = itemView.findViewById(R.id.tvCategoryName);
            productImage = itemView.findViewById(R.id.ivProductImage);
        }
    }
}
