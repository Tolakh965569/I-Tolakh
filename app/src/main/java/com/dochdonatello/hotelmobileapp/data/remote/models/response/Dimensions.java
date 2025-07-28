package com.dochdonatello.hotelmobileapp.data.remote.models.response;

import com.google.gson.annotations.SerializedName;

public class Dimensions{

	@SerializedName("depth")
	private Object depth;

	@SerializedName("width")
	private Object width;

	@SerializedName("height")
	private Object height;

	public void setDepth(Object depth){
		this.depth = depth;
	}

	public Object getDepth(){
		return depth;
	}

	public void setWidth(Object width){
		this.width = width;
	}

	public Object getWidth(){
		return width;
	}

	public void setHeight(Object height){
		this.height = height;
	}

	public Object getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"Dimensions{" + 
			"depth = '" + depth + '\'' + 
			",width = '" + width + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}