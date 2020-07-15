package com.bankwithmint.exercise.model;

import com.google.gson.annotations.SerializedName;

public class CardResponse{

	@SerializedName("number")
	private Number number;

	@SerializedName("country")
	private Country country;

	@SerializedName("bank")
	private Bank bank;

	@SerializedName("scheme")
	private String scheme;

	@SerializedName("prepaid")
	private boolean prepaid;

	@SerializedName("type")
	private String type;

	@SerializedName("brand")
	private String brand;

	public Number getNumber(){
		return number;
	}

	public Country getCountry(){
		return country;
	}

	public Bank getBank(){
		return bank;
	}

	public String getScheme(){
		return scheme;
	}

	public boolean isPrepaid(){
		return prepaid;
	}

	public String getType(){
		return type;
	}

	public String getBrand(){
		return brand;
	}
}