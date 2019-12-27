package it.jac.ledger.services;

import java.util.List;

import it.jac.ledger.dao.UserDao;
import it.jac.ledger.entities.UserBean;

public class UserService {
	UserDao userDao = new UserDao();

	public UserService() {
	}

	public List<UserBean> selTutti() {
		return this.userDao.findAll();
	}

	public UserBean selByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userDao.findByUsername(username);
	}

	public void insUser(UserBean user) {
		this.userDao.insUser(user);
	}

	public void delUser(UserBean user) {
		this.userDao.delUser(user);
	}

}
