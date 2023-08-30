package com.rabin.inventorystock.restApiproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabin.inventorystock.restApiproject.service.UserService;
import com.rabin.inventorystock.restApiproject.vo.UserVo;

@RestController
@RequestMapping("/rabin/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveUsers")
	public ResponseEntity<UserVo> registeringRecord(@RequestBody UserVo userVo) {
		UserVo user = userService.savingRecordInDataBase(userVo);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping("/showUsers")
	public ResponseEntity<List<UserVo>> showsAllRecords() {
		List<UserVo> userVo = userService.showsAllListedRecord();
		if (userVo.isEmpty()) {
			return new ResponseEntity<>(userVo, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userVo, HttpStatus.CREATED);
	}

}
