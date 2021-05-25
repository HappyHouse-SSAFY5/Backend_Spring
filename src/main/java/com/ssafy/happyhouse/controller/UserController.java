package com.ssafy.happyhouse.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.UserService;

@Controller
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<MemberDto> login(@RequestBody MemberDto member , HttpSession session, HttpServletResponse response) throws Exception {
		Map<String, String> map = new HashMap<String, String>(); 
		map.put("userid", member.getUserid());
		map.put("userpwd", member.getUserpwd());
		MemberDto memberDto = userService.login(map);
		if(memberDto != null) {
			session.setAttribute("userinfo", memberDto);
			
			Cookie cookie = new Cookie("ssafy_id", memberDto.getUserid());
			cookie.setPath("/");
			if("saveok".equals(map.get("idsave"))) {
				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);//40년간 저장.
			} else {
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value="/join")
	public ResponseEntity<MemberDto> join(@RequestBody MemberDto memberDto) throws Exception{
		int num = userService.userRegister(memberDto);
		if(num >= 1) {
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<MemberDto>> userList() {
		List<MemberDto> list = userService.userList();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value ="/mypage/{userid}")
	public ResponseEntity<MemberDto> mypage(@PathVariable("userid") String userid){
		MemberDto memberDto = userService.userInfo(userid);
		if(memberDto != null) {
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<MemberDto> update(@RequestBody MemberDto memberDto) {
		int num = userService.userModify(memberDto);
		if(num != 0) {
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/delete/{userid}")
	public ResponseEntity<MemberDto> delete(@PathVariable("userid") String userid) {
		MemberDto memberDto = userService.userInfo(userid);
		int num = userService.userDelete(userid);
		if(num != 0) {
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/findpassword", method = RequestMethod.GET)
	public String findpw() {
		return "user/findpw";	
	}
	
	@RequestMapping(value = "/sitemap", method = RequestMethod.GET)
	public String sitemap() {
		return "sitemap";	
	}
	
}
