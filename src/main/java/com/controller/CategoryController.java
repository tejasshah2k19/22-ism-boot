package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CategoryBean;
import com.dao.CategoryDao;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;

	// /category
	@PostMapping
	public ResponseEntity<?> addCategory(@RequestBody CategoryBean category) {
		categoryDao.addCategory(category);
		return ResponseEntity.ok(category);
	}
	//  /category 
	@GetMapping
	public ResponseEntity<?> getAllCategory() {
		ArrayList<CategoryBean> categories = categoryDao.getAllCategories();
		return ResponseEntity.ok(categories);
	}

	// /category/abc
	@GetMapping("/abc")
	public ResponseEntity<?> getAllCategoryAbc() {
		ArrayList<CategoryBean> categories = categoryDao.getAllCategories();
		return ResponseEntity.ok(categories);
	}
}
