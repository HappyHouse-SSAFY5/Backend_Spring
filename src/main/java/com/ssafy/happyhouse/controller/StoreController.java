package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.StoreDto;
import com.ssafy.happyhouse.model.service.StoreService;

@RestController
@RequestMapping("/store")
@CrossOrigin("*")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@PostMapping(value="/near")
	public ResponseEntity<List<StoreDto>> storeList(@RequestBody Map<String, String> map) throws Exception{
		String dong = map.get("dong");
		double lat = Double.parseDouble(map.get("lat"));
		double lng = Double.parseDouble(map.get("lng"));
		List<StoreDto> list = storeService.nearStore(dong, lat, lng);
		
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<StoreDto>>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}
