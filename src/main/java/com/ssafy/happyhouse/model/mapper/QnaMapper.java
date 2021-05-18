package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.QnaDto;
import com.ssafy.util.PageNavigation;

public interface QnaMapper {
	public int writeQna(QnaDto qnaDto);
	public List<QnaDto> listQna(Map<String, Object> map);
	public PageNavigation makePageNavigation(Map<String, String> map) ;
	
	public QnaDto getQna(int id) ;
	public void modifyQna(QnaDto qnaDto) ;
	public void deleteQna(int id) ;
}
