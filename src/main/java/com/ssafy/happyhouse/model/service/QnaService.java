package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.QnaDto;
import com.ssafy.util.PageNavigation;

public interface QnaService {
	public int writeQna(QnaDto qnaDto) throws Exception;
	public List<QnaDto> listQna(Map<String, String> map) throws Exception;
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	
	public QnaDto getQna(int id) throws Exception;
	public void modifyQna(QnaDto qnaDto) throws Exception;
	public void deleteQna(int id) throws Exception;
}
