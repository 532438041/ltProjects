package com.java.base.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import com.java.base.BaseDao;
import com.java.base.BaseService;

@Repository
public class BaseServiceImpl<T> implements BaseService<T>, ApplicationContextAware {
	private ApplicationContext applicationContext = null;
	Class<T> clazz;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@SuppressWarnings("unchecked")
	public BaseDao<T> getDao() {
		Type genType = this.getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		this.clazz = (Class<T>) params[0];
		return (BaseDao<T>) applicationContext.getBean(clazz.getSimpleName() + "Dao");
	}

	public int deleteByPrimaryKey(Long id) {
		return getDao().deleteByPrimaryKey(id);
	}

	public int insert(T t) {
		return getDao().insert(t);
	}

	public int insertSelective(T t) {
		return getDao().insertSelective(t);
	}

	public T selectByPrimaryKey(Long id) {
		return getDao().selectByPrimaryKey(id);

	}

	public int updateByPrimaryKeySelective(T t) {
		return getDao().updateByPrimaryKeySelective(t);
	}

	public int updateByPrimaryKey(T t) {
		return getDao().updateByPrimaryKey(t);
	}

}
