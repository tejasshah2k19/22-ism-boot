package com.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;

@Repository
public class CategoryDao {

	ArrayList<CategoryBean> categories = new ArrayList<>();

	public void addCategory(CategoryBean category) {
		categories.add(category);
	}
	
	public ArrayList<CategoryBean> getAllCategories(){
		return categories;
	}
}
