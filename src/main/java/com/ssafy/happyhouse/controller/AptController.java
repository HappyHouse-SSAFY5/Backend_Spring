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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.AptInfoDto;
import com.ssafy.happyhouse.model.service.SearchService;

@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class AptController {
	private static final Logger logger = LoggerFactory.getLogger(AptController.class);
	
	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/dong", method = RequestMethod.POST)
	public ResponseEntity<List<AptInfoDto>> list(@RequestBody Map<String, String> map) throws Exception {
		List<AptInfoDto> list = searchService.listDong(map);
		if(list.size() != 0) {
			return new ResponseEntity<List<AptInfoDto>>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}
