package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.PickedHouseDto;

public interface PickedHouseService {
	// 찜 목록 출력
	public List<PickedHouseDto> pickedHouseList(String userid)throws SQLException;
	
	// 찜 한 것 상세 보기
	public PickedHouseDto pickedHouseDetail(int pickedId)throws SQLException;
	
	// 찜하기
	public int pick(Map<String, String> map) throws SQLException;
	
	// 찜 없애기
	public int unpick(Map<String, String> map) throws SQLException;
	
	// 찜한 목록 출력을 위한 좋아요 기록
	public int[] userPicks(String userid) throws SQLException;
}
