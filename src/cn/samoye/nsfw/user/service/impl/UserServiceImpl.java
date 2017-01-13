package cn.samoye.nsfw.user.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.samoye.nsfw.user.bean.User;
import cn.samoye.nsfw.user.dao.UserDao;
import cn.samoye.nsfw.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(Serializable id) {
		userDao.delete(id);
	}

	@Override
	public User queryUserById(Serializable id) {
		return userDao.queryObjectById(id);
	}

	@Override
	public List<User> queryUserList() {
		return userDao.queryObjectList();
	}

}
