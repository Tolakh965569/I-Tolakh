package com.dochdonatello.hotelmobileapp.data.remote.models.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductResponse{

	@SerializedName("total")
	private int total;

	@SerializedName("limit")
	private int limit;

	@SerializedName("skip")
	private int skip;

	@SerializedName("products")
	private List<ProductsItem> products;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setLimit(int limit){
		this.limit = limit;
	}

	public int getLimit(){
		return limit;
	}

	public void setSkip(int skip){
		this.skip = skip;
	}

	public int getSkip(){
		return skip;
	}

	public void setProducts(List<ProductsItem> products){
		this.products = products;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}

	@Override
 	public String toString(){
		return 
			"ProductResponse{" + 
			"total = '" + total + '\'' + 
			",limit = '" + limit + '\'' + 
			",skip = '" + skip + '\'' + 
			",products = '" + products + '\'' + 
			"}";
		}
}