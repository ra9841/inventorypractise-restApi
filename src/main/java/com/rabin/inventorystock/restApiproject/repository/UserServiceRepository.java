package com.rabin.inventorystock.restApiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rabin.inventorystock.restApiproject.entity.UserEntity;
@Repository
public interface UserServiceRepository extends JpaRepository<UserEntity,Integer>{

}
