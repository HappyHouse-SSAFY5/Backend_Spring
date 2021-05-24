package com.ssafy.happyhouse.model;

public class StoreDto {
	private int store_num;
	private String store_name;
	private String branch_name;
	private String code;
	private String part_name;
	private String mid_part_name;
	private String sm_part_name;
	private String dong_code;
	private String dong_name;
	private String building_name;
	private String address;
	private double lat;
	private double lng;
	
	public StoreDto(int storeIdx, String storeName, String branchName, String code, String part_name,
			String mid_part_name, String sm_part_name, String dong_code, String dong_name, String building_name,
			String address, double lat, double lng) {
		super();
		this.store_num = storeIdx;
		this.store_name = storeName;
		this.branch_name = branchName;
		this.code = code;
		this.part_name = part_name;
		this.mid_part_name = mid_part_name;
		this.sm_part_name = sm_part_name;
		this.dong_code = dong_code;
		this.dong_name = dong_name;
		this.building_name = building_name;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
	}

	public int getStoreIdx() {
		return store_num;
	}

	public void setStoreIdx(int storeIdx) {
		this.store_num = storeIdx;
	}

	public String getStoreName() {
		return store_name;
	}

	public void setStoreName(String storeName) {
		this.store_name = storeName;
	}

	public String getBranchName() {
		return branch_name;
	}

	public void setBranchName(String branchName) {
		this.branch_name = branchName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

	public String getMid_part_name() {
		return mid_part_name;
	}

	public void setMid_part_name(String mid_part_name) {
		this.mid_part_name = mid_part_name;
	}

	public String getSm_part_name() {
		return sm_part_name;
	}

	public void setSm_part_name(String sm_part_name) {
		this.sm_part_name = sm_part_name;
	}

	public String getDong_code() {
		return dong_code;
	}

	public void setDong_code(String dong_code) {
		this.dong_code = dong_code;
	}

	public String getDong_name() {
		return dong_name;
	}

	public void setDong_name(String dong_name) {
		this.dong_name = dong_name;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	/**
	 * 위도 경도 차를 이용해 두 지점 사이의 거리를 구하는 메소드
	 * Haversine formula 이용, 코드 참고 https://kayuse88.github.io/haversine/
	 * */
	public double getDistance(double lat, double lng) {
		double radius = 6371;
		double toRadian = Math.PI / 180;
		
		double deltaLatitude = Math.abs(this.lat - lat) * toRadian;
		double deltaLongitude = Math.abs(this.lng - lng) * toRadian;
		
		double sinDeltaLat = Math.sin(deltaLatitude / 2);
	    double sinDeltaLng = Math.sin(deltaLongitude / 2);
	    
	    double squareRoot = Math.sqrt(
	            sinDeltaLat * sinDeltaLat +
	            Math.cos(this.lat * toRadian) * Math.cos(lat * toRadian) * sinDeltaLng * sinDeltaLng);
		
		return  2 * radius * Math.asin(squareRoot);
	}
	@Override
	public String toString() {
		return "StoreDto [storeIdx=" + store_num + ", storeName=" + store_name + ", branchName=" + branch_name + ", code="
				+ code + ", part_name=" + part_name + ", mid_part_name=" + mid_part_name + ", sm_part_name="
				+ sm_part_name + ", dong_code=" + dong_code + ", dong_name=" + dong_name + ", building_name="
				+ building_name + ", address=" + address + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
}
