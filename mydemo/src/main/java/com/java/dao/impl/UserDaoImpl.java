package com.java.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.base.impl.BaseDaoImpl;
import com.java.dao.UserDao;
import com.java.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User>implements UserDao {

	@Override
	public int checkLogin(String userName, String userPwd) {
		Map<String, Object> map = new HashMap<>();
		map.put("userName", userName);
		map.put("userPwd", userPwd);
		return this.getSqlSession().selectOne(getStateMentName("checkLogin"), map);
	}

	@Override
	public List<User> getUserList() {
		return this.getSqlSession().selectList(getStateMentName("getUserList"));
	}

}
