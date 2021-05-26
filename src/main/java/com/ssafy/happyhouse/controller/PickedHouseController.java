package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.PickedHouseDto;
import com.ssafy.happyhouse.model.service.PickedHouseService;
import com.ssafy.happyhouse.model.service.SearchService;

@RestController
@CrossOrigin("*")
public class PickedHouseController {
	/**
	 * 하나의 집에 대해서 저장을 하는 것으로 하자. housedeal_no를 통해 집 정보를 얻을 수 있다.
	 * */
	@Autowired
	private PickedHouseService pickedHouseService;
	
	@GetMapping(value = "/pick/list/{userid}")
	public ResponseEntity<List<PickedHouseDto>> pickedHouseList(@PathVariable("userid") String userid) throws SQLException {
		System.out.println("userid");
		System.out.println(userid);
		List<PickedHouseDto> list = pickedHouseService.pickedHouseList(userid);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<PickedHouseDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value = "/pick")
	public ResponseEntity<Integer> pick(@RequestBody Map<String, String> map) throws SQLException {
		int cnt = pickedHouseService.pick(map);
		if(cnt != 0) {
			return new ResponseEntity<Integer>(HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/pick/housedeal/{userid}")
	public ResponseEntity<int[]> userPicks(@PathVariable("userid") String userid) throws SQLException {
		int[] pickedId = pickedHouseService.userPicks(userid);
		if(pickedId != null && pickedId.length != 0) {
			System.out.println("on housedeal");
			System.out.println(pickedId);
			return new ResponseEntity<int[]>(pickedId, HttpStatus.OK);
		}
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/unpick")
	public ResponseEntity<List<PickedHouseDto>> unpick(@RequestBody Map<String, String> map) throws SQLException{
		System.out.println(map);
		pickedHouseService.unpick(map);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
