package com.rabin.inventorystock.restApiproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public UserVo registeringRecord(@RequestBody UserVo userVo) {
		UserVo user=userService.savingRecordInDataBase(userVo);
		return user;
	}
	
	@GetMapping("/showUsers")
	public List<UserVo> showsAllRecords(){
		List<UserVo>userVo=userService.showsAllListedRecord();
		return userVo;
	}

}
