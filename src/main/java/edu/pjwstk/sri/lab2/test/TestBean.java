package edu.pjwstk.sri.lab2.test;

import edu.pjwstk.sri.lab2.dao.CategoryDao;
import edu.pjwstk.sri.lab2.model.Category;

import java.util.List;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("testBean")
@RequestScoped
public class TestBean implements Serializable {

	@Inject
	private CategoryDao catService;
	
	public TestBean() {
	}
	
	public void test() {
		List<Category> listAll = catService.listAll(null, null);
		System.out.println(listAll);
	}

	public List<Category> getAllCategories() {
		return catService.listAll(null, null);
	}


}
