package com.ssafy.happyhouse.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.GuestBookDto;
import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.QnaDto;
import com.ssafy.happyhouse.model.service.GuestBookService;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/article")
@CrossOrigin("*")
public class GuestBookController {

	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private GuestBookService guestBookService;
	
	@PostMapping(value="/write")
	public ResponseEntity<List<GuestBookDto>> write(@RequestBody GuestBookDto guestBookDto) throws Exception {
		int num = guestBookService.writeArticle(guestBookDto);
		Map<String, String> map = new HashMap<>();
		map.put("key", "");
		map.put("word", "");
		map.put("spp", "10");//sizePerPage
		
		if(num >= 1) {
			List<GuestBookDto> list = guestBookService.listArticle(map);
			return new ResponseEntity<List<GuestBookDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/detail/{articleno}")
	public ResponseEntity<GuestBookDto> getNotice(@PathVariable("articleno") int articleno) throws Exception {
		GuestBookDto guestBookDto = guestBookService.getArticle(articleno);
		if(guestBookDto != null)
			return new ResponseEntity<GuestBookDto>(guestBookDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<GuestBookDto>> list(@RequestParam Map<String, String> map) throws Exception {
		String spp = map.get("spp");
		System.out.println(map.get("key"));
		System.out.println(map.get("word"));
		map.put("spp", spp != null ? spp : "10");//sizePerPage

		List<GuestBookDto> list = guestBookService.listArticle(map);
		PageNavigation pageNavigation = guestBookService.makePageNavigation(map);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<GuestBookDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping(value = "/modify")
	public ResponseEntity<List<GuestBookDto>> modifyArticle (@RequestBody GuestBookDto guestBookDto) throws Exception {
		guestBookService.modifyArticle(guestBookDto);
		Map<String, String> map = new HashMap<>();
		map.put("key", "");
		map.put("word", "");
		map.put("spp", "10");//sizePerPage
		List<GuestBookDto> list = guestBookService.listArticle(map);
		return new ResponseEntity<List<GuestBookDto>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{articleno}")
	public ResponseEntity<List<GuestBookDto>> delete(@PathVariable("articleno") int articleno) throws Exception {
		guestBookService.deleteArticle(articleno);
		Map<String, String> map = new HashMap<>();
		map.put("key", "");
		map.put("word", "");
		map.put("spp", "10");//sizePerPage
		List<GuestBookDto> list = guestBookService.listArticle(map);
		return new ResponseEntity<List<GuestBookDto>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public ModelAndView downloadFile(@RequestParam("sfolder") String sfolder, @RequestParam("ofile") String ofile, 
				@RequestParam("sfile") String sfile, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if(memberDto != null) {
			Map<String, Object> fileInfo = new HashMap<String, Object>();
		    fileInfo.put("sfolder", sfolder);
		    fileInfo.put("ofile", ofile);
		    fileInfo.put("sfile", sfile);
		 
		    return new ModelAndView("fileDownLoadView", "downloadFile", fileInfo);
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
}
