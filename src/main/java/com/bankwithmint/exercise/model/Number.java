package com.bankwithmint.exercise.model;

import com.google.gson.annotations.SerializedName;

public class Number{

	@SerializedName("length")
	private int length;

	@SerializedName("luhn")
	private boolean luhn;

	public int getLength(){
		return length;
	}

	public boolean isLuhn(){
		return luhn;
	}
}