package com.UserDao;

import java.util.List;

import com.model.User;
public interface UserDao {
public void insertUser(User user);
public List<User> retrive();
public User getUser(String emailid);
public void updateUser(User user);
public void removeUser(String emaild);
}
