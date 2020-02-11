package ru.msai.paper.main;

import java.util.List;
import com.google.gson.annotations.SerializedName;

class MainResponse {

	// JSON Array
	@SerializedName("paper")
	private List<MainModel> paper;

	@SerializedName("error")
	private boolean error;

	// Getters and Setters
	public void setPaper(List<MainModel> paper){
		this.paper = paper;
	}

	public List<MainModel> getPaper(){
		return paper;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}
}