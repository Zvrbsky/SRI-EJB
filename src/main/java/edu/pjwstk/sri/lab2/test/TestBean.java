package edu.pjwstk.sri.lab2.test;

import edu.pjwstk.sri.lab2.dao.CategoryDao;
import edu.pjwstk.sri.lab2.dao.ProductDao;
import edu.pjwstk.sri.lab2.dto.OrderItem;
import edu.pjwstk.sri.lab2.model.Category;
import edu.pjwstk.sri.lab2.model.Product;
import edu.pjwstk.sri.lab2.storage.Cart;

import java.util.List;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("testBean")
@SessionScoped
public class TestBean implements Serializable {

    @Inject
    private CategoryDao catService;
    @Inject
    private ProductDao prodService;
    @Inject
    private Cart cart;

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

	public List<OrderItem> getAllItemsInCart() {
		return cart.listAll();
	}

    public void addToCart(Long id, Integer amount)
	{
		cart.addToCart(id, amount);
	}

	public void confirmOrder()
	{
		cart.confirmOrder();
	}
}
