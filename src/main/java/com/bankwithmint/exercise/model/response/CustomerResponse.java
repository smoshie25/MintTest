package com.bankwithmint.exercise.model.response;

import com.google.gson.annotations.SerializedName;

public class CustomerResponse{

	@SerializedName("payload")
	private Payload payload;

	@SerializedName("success")
	private boolean success;

	public void setPayload(Payload payload){
		this.payload = payload;
	}

	public Payload getPayload(){
		return payload;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}
}