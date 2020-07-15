package com.bankwithmint.exercise.model;

import com.google.gson.annotations.SerializedName;

public class Bank{

	@SerializedName("phone")
	private String phone;

	@SerializedName("city")
	private String city;

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public String getPhone(){
		return phone;
	}

	public String getCity(){
		return city;
	}

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}