package com.bankwithmint.exercise.model.response;

import com.google.gson.annotations.SerializedName;

public class Payload{

	@SerializedName("bank")
	private String bank;

	@SerializedName("scheme")
	private String scheme;

	@SerializedName("type")
	private String type;

	public void setBank(String bank){
		this.bank = bank;
	}

	public String getBank(){
		return bank;
	}

	public void setScheme(String scheme){
		this.scheme = scheme;
	}

	public String getScheme(){
		return scheme;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}