package com.bean;

public class CategoryBean {

	Integer categoryId;
	String category;

	public CategoryBean() {
		this.categoryId = (int) (Math.random() * 1000000);
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
