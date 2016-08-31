package com.java.dao;

import java.util.List;

import com.java.base.BaseDao;
import com.java.entity.User;

public interface UserDao extends BaseDao<User>{

	int checkLogin(String userName, String userPwd);

	List<User> getUserList();

}