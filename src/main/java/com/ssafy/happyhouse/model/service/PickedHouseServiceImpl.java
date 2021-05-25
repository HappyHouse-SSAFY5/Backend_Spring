package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.PickedHouseDto;
import com.ssafy.happyhouse.model.mapper.PickedHouseMapper;

@Service
public class PickedHouseServiceImpl implements PickedHouseService{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PickedHouseDto> pickedHouseList(String userid) throws SQLException {
		return sqlSession.getMapper(PickedHouseMapper.class).pickedHouseList(userid);
	}
	
	@Override
	public PickedHouseDto pickedHouseDetail(int pickedid) throws SQLException {
		return sqlSession.getMapper(PickedHouseMapper.class).pickedHouseDetail(pickedid);
	}

	@Override
	public int pick(Map<String, String> map) throws SQLException {
		return sqlSession.getMapper(PickedHouseMapper.class).pick(map);
	}

	@Override
	public int unpick(int pickedid) throws SQLException {
		return sqlSession.getMapper(PickedHouseMapper.class).unpick(pickedid);
	}
}
