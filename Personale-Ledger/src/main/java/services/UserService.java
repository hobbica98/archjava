package services;

import java.util.List;

import entities.User;

public interface UserService {
    public List<User> SelTutti();
    public User SelByUsername(String username);
    public void InsUser(User user);
    public void DelUser(User user);
}
