package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.base.impl.BaseServiceImpl;
import com.java.dao.MenuDao;
import com.java.entity.Menu;
import com.java.service.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu>implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> getMenuTree(String userId) {
		return menuDao.getMenuTree(userId);
	}

	@Override
	public List<Menu> getMenuList() {
		return menuDao.getMenuList();
	}

}
