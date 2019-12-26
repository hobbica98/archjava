package it.jac.ledger.services;

import java.util.List;

import it.jac.ledger.dao.UserDao;
import it.jac.ledger.entities.UserBean;

public class UserService {
	UserDao userDao = new UserDao();

	public UserService() {
	}

	public List<UserBean> SelTutti() {
		return this.userDao.findAll();
	}

	public UserBean SelByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userDao.findByUsername(username);
	}

	public void InsUser(UserBean user) {
		this.userDao.InsUser(user);
	}

	public void DelUser(UserBean user) {
		this.userDao.DelUser(user);
	}

}
