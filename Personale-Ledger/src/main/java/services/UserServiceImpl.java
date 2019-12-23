package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.User;
import repository.UserRepo;

public class UserServiceImpl implements  UserService{

	@Autowired
    public UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
	@Override
	public List<User> SelTutti() {
		return this.userRepo.findAll();
	}

	@Override
	public User SelByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userRepo.findByUsername(username);
	}

	@Override
	public void InsUser(User user) {
	
		
	}
	
	@Override
	public void DelUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
