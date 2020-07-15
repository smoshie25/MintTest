package com.bankwithmint.exercise.model;

import com.google.gson.annotations.SerializedName;

public class Country{

	@SerializedName("emoji")
	private String emoji;

	@SerializedName("latitude")
	private int latitude;

	@SerializedName("alpha2")
	private String alpha2;

	@SerializedName("name")
	private String name;

	@SerializedName("numeric")
	private String numeric;

	@SerializedName("currency")
	private String currency;

	@SerializedName("longitude")
	private int longitude;

	public String getEmoji(){
		return emoji;
	}

	public int getLatitude(){
		return latitude;
	}

	public String getAlpha2(){
		return alpha2;
	}

	public String getName(){
		return name;
	}

	public String getNumeric(){
		return numeric;
	}

	public String getCurrency(){
		return currency;
	}

	public int getLongitude(){
		return longitude;
	}
}