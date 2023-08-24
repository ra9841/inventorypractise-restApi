package com.rabin.inventorystock.restApiproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabin.inventorystock.restApiproject.encrypt.ProtectDataSerializer;
import com.rabin.inventorystock.restApiproject.entity.UserEntity;
import com.rabin.inventorystock.restApiproject.repository.UserServiceRepository;
import com.rabin.inventorystock.restApiproject.vo.UserVo;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserServiceRepository userServiceRepository;
	

	@Override
	public UserVo savingRecordInDataBase(UserVo userVo) {
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(userVo, userEntity);
		userServiceRepository.save(userEntity);
		UserVo userVoo=new UserVo();
		BeanUtils.copyProperties(userEntity, userVoo);
		return userVoo;
	}

	@Override
	public List<UserVo> showsAllListedRecord() {
		List<UserEntity>userEntity=userServiceRepository.findAll();
		List<UserVo>userVoList=new ArrayList<>();
		for(UserEntity user:userEntity) {
			UserVo userVo=new UserVo();
			BeanUtils.copyProperties(user, userVo);
			userVoList.add(userVo);
		}
		return userVoList;
	}

}
