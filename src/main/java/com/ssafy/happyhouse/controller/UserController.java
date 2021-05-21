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
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "user/join";	
	}
	
	@PostMapping(value="/join")
	public ResponseEntity<MemberDto> join(@RequestBody MemberDto memberDto) throws Exception{
		int num = userService.userRegister(memberDto);
		System.out.println("여기여기여기");
		System.out.println(num);
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
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Model model, HttpSession session) { // 마이페이지
		try {
			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
			System.out.println(memberDto);
			model.addAttribute("userinfo", memberDto);
			return "user/mypage";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "마이페이지 로딩 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberDto memberDto, Model model) {
		try {
			System.out.println(memberDto);
			userService.userModify(memberDto);
			return "home";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원 정보 수정 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpSession session) { // 회원탈퇴
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		String id = memberDto.getUserid();
		userService.userDelete(id);
		session.invalidate();
		return "home";
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
