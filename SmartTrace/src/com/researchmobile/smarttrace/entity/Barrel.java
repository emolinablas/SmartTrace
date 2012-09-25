package com.researchmobile.smarttrace.entity;

import java.io.Serializable;

public class Barrel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String user;
	private String state;
	private String hour1;
	private String hour2;
	private String date1;
	private String date2;
	private String path;
	private String luz;
	private String temperatura;
	private int capture;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getLuz() {
		return luz;
	}
	public void setLuz(String luz) {
		this.luz = luz;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public int getCapture() {
		return capture;
	}
	public void setCapture(int capture) {
		this.capture = capture;
	}
	public String getHour1() {
		return hour1;
	}
	public void setHour1(String hour1) {
		this.hour1 = hour1;
	}
	public String getHour2() {
		return hour2;
	}
	public void setHour2(String hour2) {
		this.hour2 = hour2;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

}
