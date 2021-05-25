package com.ssafy.happyhouse.model;

public class PickedHouseDto {
	private int id;
	private String user_id;
	private double lat;
	private double lng;
	private String dong;
	private String code;
	private String apt_name;
	private String deal_amount;
	private String deal_year;
	private String deal_month;
	private String deal_day;
	private String area;
	private String floor;
	public PickedHouseDto(int id, String user_id, double lat, double lng, String dong, String code, String apt_name,
			String deal_amount, String deal_year, String deal_month, String deal_day, String area, String floor) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.lat = lat;
		this.lng = lng;
		this.dong = dong;
		this.code = code;
		this.apt_name = apt_name;
		this.deal_amount = deal_amount;
		this.deal_year = deal_year;
		this.deal_month = deal_month;
		this.deal_day = deal_day;
		this.area = area;
		this.floor = floor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getApt_name() {
		return apt_name;
	}
	public void setApt_name(String apt_name) {
		this.apt_name = apt_name;
	}
	public String getDeal_amount() {
		return deal_amount;
	}
	public void setDeal_amount(String deal_amount) {
		this.deal_amount = deal_amount;
	}
	public String getDeal_year() {
		return deal_year;
	}
	public void setDeal_year(String deal_year) {
		this.deal_year = deal_year;
	}
	public String getDeal_month() {
		return deal_month;
	}
	public void setDeal_month(String deal_month) {
		this.deal_month = deal_month;
	}
	public String getDeal_day() {
		return deal_day;
	}
	public void setDeal_day(String deal_day) {
		this.deal_day = deal_day;
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
		return "PickedHouseDto [id=" + id + ", user_id=" + user_id + ", lat=" + lat + ", lng=" + lng + ", dong=" + dong
				+ ", code=" + code + ", apt_name=" + apt_name + ", deal_amount=" + deal_amount + ", deal_year="
				+ deal_year + ", deal_month=" + deal_month + ", deal_day=" + deal_day + ", area=" + area + ", floor="
				+ floor + "]";
	}
}
