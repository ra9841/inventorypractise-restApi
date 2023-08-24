package com.rabin.inventorystock.restApiproject.service;

import java.util.List;

import com.rabin.inventorystock.restApiproject.vo.UserVo;

public interface UserService {

	UserVo savingRecordInDataBase(UserVo userVo);

	List<UserVo> showsAllListedRecord();

}
