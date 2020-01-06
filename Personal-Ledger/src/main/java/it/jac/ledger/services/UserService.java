package it.jac.ledger.services;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Service;

import it.jac.ledger.dao.UserDao;
import it.jac.ledger.entities.UserBean;
@Service
public class UserService {
	UserDao userDao = new UserDao();

	public UserService() {
	}

	public List<UserBean> selTutti() {
		return this.userDao.findAll();
	}

	public UserBean selByUsername(String username) {
		return this.userDao.findByUsername(username);
	}

	public void insUser(UserBean user) throws PersistenceException {
		this.userDao.insUser(user);
	}

	public void delUser(UserBean user) {
		this.userDao.delUser(user);
	}

}
