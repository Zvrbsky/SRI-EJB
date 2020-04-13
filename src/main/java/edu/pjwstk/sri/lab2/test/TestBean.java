package edu.pjwstk.sri.lab2.test;

import edu.pjwstk.sri.lab2.dao.CategoryDao;
import edu.pjwstk.sri.lab2.dao.ProductDao;
import edu.pjwstk.sri.lab2.model.Category;
import edu.pjwstk.sri.lab2.model.Product;

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
	@Inject
	private ProductDao prodService;
	
	public TestBean() {
	}
	
	public void test() {
		List<Category> listAll = catService.listAll();
		System.out.println(listAll);
	}

	public List<Category> getAllCategories() {
		return catService.listAll();
	}
	public List<Product> getAllProducts() {
		return prodService.listAll(null, null);
	}
}
