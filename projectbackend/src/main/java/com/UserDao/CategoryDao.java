package com.UserDao;

import java.util.List;

import com.model.Category;


public interface CategoryDao {
public void insertCategory(Category category);
public Category getCategory(int catid);
public List<Category> retrive();
public void removeCategory(Category category);
public void updateCategory(Category category);
}
