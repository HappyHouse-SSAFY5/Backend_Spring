package com.ssafy.happyhouse.model;

public class AptInfoDto {
	public static String dealType = "아파트 매매";
	private String AptName;
	private String dealAmount;
//	private String dealDate;
	private String dealDay;
	private String dealMonth;
	private String dealYear;
	
	
	private String area;
	private String dong;
	private String lat;
	private String lng;
	public AptInfoDto(){}
	public AptInfoDto(String aptName, String dealAmount, String area, String sido, String gugun, String dong,
			String lat, String lng) {
		super();
		this.AptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.dong = dong;
		this.lat = lat;
		this.lng = lng;
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
//	public String getDealDate() {
//		return dealDate;
//	}
//	public void setDealDate(String dealDate) {
//		this.dealDate = dealDate;
//	}
	
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
	@Override
	public String toString() {
		return "AptInfoDto [aptName=" + AptName + ", dealAmount=" + dealAmount + ", dealday=" + dealDay + ", dealMonth="
				+ dealMonth + ", dealYear=" + dealYear + ", area=" + area + ", dong=" + dong + ", lat=" + lat + ", lng="
				+ lng + "]";
	}

}
