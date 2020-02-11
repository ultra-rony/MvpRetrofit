package ru.msai.paper.main;

import com.google.gson.annotations.SerializedName;

class MainModel {

	// JSON Object
	@SerializedName("date_time")
	private String dateTime;

	@SerializedName("paper")
	private String paper;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	// Getters and Setters
	public void setDateTime(String dateTime){
		this.dateTime = dateTime;
	}

	public String getDateTime(){
		return dateTime;
	}

	public void setPaper(String paper){
		this.paper = paper;
	}

	public String getPaper(){
		return paper;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}
}