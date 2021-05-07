package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.AptInfoDto;

public interface SearchService {
	// 동 검색
	List<AptInfoDto> listDong(Map<String, String> map) throws Exception;
}
