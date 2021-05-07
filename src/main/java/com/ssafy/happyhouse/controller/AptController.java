package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.AptInfoDto;
import com.ssafy.happyhouse.model.service.SearchService;

@Controller
@RequestMapping("/search")
public class AptController {
	private static final Logger logger = LoggerFactory.getLogger(AptController.class);
	
	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/dong", method = RequestMethod.GET)
	public String list(@RequestParam Map<String, String> map, Model model) throws Exception {
		List<AptInfoDto> list = searchService.listDong(map);
		model.addAttribute("apts", list);
		return "search/dong_result";
	}
}
