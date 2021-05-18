package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.QnaDto;
import com.ssafy.happyhouse.model.service.QnaService;
import com.ssafy.util.PageNavigation;


@RestController
@RequestMapping("/qna")
@CrossOrigin("*")
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private QnaService qnaService;
	
	@PostMapping(value = "/registration")
	public ResponseEntity<List<QnaDto>> userRegister(@RequestBody QnaDto qnaDto) throws Exception {
		int cnt = qnaService.writeQna(qnaDto);
		Map<String, String> map = new HashMap<>();
		map.put("key", "");
		map.put("word", "");
		map.put("spp", "10");//sizePerPage
		if(cnt != 0) {
			List<QnaDto> list = qnaService.listQna(map);
			return new ResponseEntity<List<QnaDto>>(list, HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<QnaDto>> qnaList(@RequestParam Map<String, String> map) throws Exception {
		String spp = map.get("spp");
		System.out.println(map.get("key"));
		System.out.println(map.get("word"));
		map.put("spp", spp != null ? spp : "10");//sizePerPage

		List<QnaDto> list = qnaService.listQna(map);
		PageNavigation pageNavigation = qnaService.makePageNavigation(map);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<QnaDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping(value = "/detail/{id}")
	public ResponseEntity<QnaDto> getQna(@PathVariable("id") String id) throws Exception {
		int intid=Integer.parseInt(id);
		QnaDto qnaDto = qnaService.getQna(intid);
		if(qnaDto != null)
			return new ResponseEntity<QnaDto>(qnaDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping(value = "/modify")
	public ResponseEntity<List<QnaDto>> qnaModify(@RequestBody QnaDto qnaDto) throws Exception {
		qnaService.modifyQna(qnaDto);
		Map<String, String> map = new HashMap<>();
		map.put("key", "");
		map.put("word", "");
		map.put("spp", "10");//sizePerPage
		List<QnaDto> list = qnaService.listQna(map);
		return new ResponseEntity<List<QnaDto>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<List<QnaDto>> qnaDelete(@PathVariable("id") String id) throws Exception {
		int intid=Integer.parseInt(id);
		qnaService.deleteQna(intid);
		Map<String, String> map = new HashMap<>();
		map.put("key", "");
		map.put("word", "");
		map.put("spp", "10");//sizePerPage
		List<QnaDto> list = qnaService.listQna(map);
		return new ResponseEntity<List<QnaDto>>(list, HttpStatus.OK);
	}
	
	
}
