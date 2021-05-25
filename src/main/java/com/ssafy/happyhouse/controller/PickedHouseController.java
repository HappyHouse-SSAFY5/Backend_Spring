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
		List<PickedHouseDto> list = pickedHouseService.pickedHouseList(userid);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<PickedHouseDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value = "/pick")
	public ResponseEntity<Integer> userRegister(@RequestBody Map<String, String> map) throws SQLException {
		int cnt = pickedHouseService.pick(map);
		if(cnt != 0) {
			return new ResponseEntity<Integer>(HttpStatus.OK);
		} else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/pick")
	public ResponseEntity<PickedHouseDto> userInfo(@PathVariable("pickedid") String pickedid) throws SQLException {
		PickedHouseDto pickedHouseDto = pickedHouseService.pickedHouseDetail(Integer.parseInt(pickedid));
		if(pickedHouseDto != null)
			return new ResponseEntity<PickedHouseDto>(pickedHouseDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/unpick/{userid}/{pickedid}")
	public ResponseEntity<List<PickedHouseDto>> unpick(@PathVariable("userid") String userid, @PathVariable("pickedid") String pickedid) throws SQLException{
		pickedHouseService.unpick(Integer.parseInt(pickedid));
		List<PickedHouseDto> list = pickedHouseService.pickedHouseList(userid);
		return new ResponseEntity<List<PickedHouseDto>>(list, HttpStatus.OK);
	}
}
