package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.StoreDto;

public interface StoreService {
	// 동에 대한 주변 상권 검색
	List<StoreDto> nearStore(String dong, double lat, double lng) throws Exception;
}
