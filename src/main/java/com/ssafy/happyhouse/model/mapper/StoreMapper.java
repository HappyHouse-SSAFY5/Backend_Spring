package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.StoreDto;

public interface StoreMapper {
	/**
	 * dong 검색에 대해 주변 상권 결과 표시하기
	 * */
	public List<StoreDto> nearStore(String dong) throws SQLException;
}
