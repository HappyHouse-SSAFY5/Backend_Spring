package com.ssafy.happyhouse.model;

public class PickedHouseDto {
	private int pickid;
	private double lat;
	private double lng;
	private String dong;
	private String code;
	private String AptName;
	private int housedeal_no;
	private String dealAmount;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private String area;
	private String floor;
	public PickedHouseDto(int pickid, double lat, double lng, String dong, String code, String aptName, int housedeal_no,
			String dealAmount, String dealYear, String dealMonth, String dealDay, String area, String floor) {
		super();
		this.pickid = pickid;
		this.lat = lat;
		this.lng = lng;
		this.dong = dong;
		this.code = code;
		AptName = aptName;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.housedeal_no = housedeal_no;
	}
	public int getPickid() {
		return pickid;
	}
	public void setPickid(int pickid) {
		this.pickid = pickid;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAptName() {
		return AptName;
	}
	public void setAptName(String aptName) {
		AptName = aptName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getDealDay() {
		return dealDay;
	}
	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	@Override
	public String toString() {
		return "PickedHouseDto [pickid=" + pickid + ", lat=" + lat + ", lng=" + lng + ", dong=" + dong + ", code="
				+ code + ", AptName=" + AptName + ", dealAmount=" + dealAmount + ", dealYear=" + dealYear
				+ ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", area=" + area + ", floor=" + floor + "housedeal_no="+housedeal_no+"]";
	}
}
