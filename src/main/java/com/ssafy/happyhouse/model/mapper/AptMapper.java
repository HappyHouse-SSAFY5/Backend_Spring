package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.AptInfoDto;

public interface AptMapper {
	// 동 검색
	List<AptInfoDto> listDong(Map<String, Object> map) throws Exception;
}
