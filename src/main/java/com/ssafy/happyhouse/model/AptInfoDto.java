package com.ssafy.happyhouse.model;

public class AptInfoDto {
	public static String dealType = "아파트 매매";
	private int rnum;
	private int housedeal_no;
	private String AptName;
	private String dealAmount;
	private String code;
	private String dealDay;
	private String dealMonth;
	private String dealYear;
	private String floor;
	
	private String area;
	private String dong;
	private String lat;
	private String lng;
	public AptInfoDto(){}
	public AptInfoDto(int rnum, int housedeal_no, String aptName, String dealAmount,String code, String area, String sido, String gugun, String dong,
			String lat, String lng, String floor) {
		super();
		this.rnum = rnum;
		this.housedeal_no = housedeal_no;
		this.AptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.dong = dong;
		this.lat = lat;
		this.lng = lng;
		this.floor = floor;
		this.code = code;
	}

	public int getHousedeal_no() {
		return housedeal_no;
	}
	public void setHousedeal_no(int housedeal_no) {
		this.housedeal_no = housedeal_no;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public static String getDealType() {
		return dealType;
	}

	public static void setDealType(String dealType) {
		AptInfoDto.dealType = dealType;
	}

	public String getAptName() {
		return AptName;
	}

	public void setAptName(String aptName) {
		this.AptName = aptName;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
	public String getDealDay() {
		return dealDay;
	}
	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}
	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "AptInfoDto [rnum=" + rnum + ", housedeal_no=" + housedeal_no + ", AptName=" + AptName + ", dealAmount="
				+ dealAmount + ", code=" + code + ", dealDay=" + dealDay + ", dealMonth=" + dealMonth + ", dealYear="
				+ dealYear + ", floor=" + floor + ", area=" + area + ", dong=" + dong + ", lat=" + lat + ", lng=" + lng + "]";
	}
}
