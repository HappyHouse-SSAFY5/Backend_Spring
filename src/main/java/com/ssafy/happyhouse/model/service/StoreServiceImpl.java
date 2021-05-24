package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.StoreDto;
import com.ssafy.happyhouse.model.mapper.StoreMapper;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<StoreDto> nearStore(String dong , double lat, double lng) throws Exception {
		return sqlSession.getMapper(StoreMapper.class).nearStore(dong).stream().filter(store -> store.getDistance(lat, lng) <= 0.5).collect(Collectors.toList());
	}

}
