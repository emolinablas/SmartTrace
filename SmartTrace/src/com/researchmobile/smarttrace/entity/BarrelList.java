package com.researchmobile.smarttrace.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BarrelList implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static List<Barrel> barrelList = new ArrayList<Barrel>();

	public static List<Barrel> getBarrelList() {
		return barrelList;
	}

	public void setBarrelList(List<Barrel> barrelList) {
		this.barrelList = barrelList;
	}
}
