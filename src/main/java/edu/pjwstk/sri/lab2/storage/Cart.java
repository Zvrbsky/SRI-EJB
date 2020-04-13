package edu.pjwstk.sri.lab2.storage;

import edu.pjwstk.sri.lab2.dao.ProductDao;
import edu.pjwstk.sri.lab2.dto.OrderItem;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class Cart {

    @Inject
    private ProductDao prodService;

    private List<OrderItem> orderItems;

    public Cart()
    {
        System.out.println("DBG: Cart c-tor");
        orderItems = new ArrayList<OrderItem>();
    }

    public void addToCart(Long id, Integer amount)
    {
        System.out.println("DBG: Added product: " + id + " to Cart. Amount: " + amount);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(prodService.findById(id));
        orderItem.setAmount(amount);
        orderItems.add(orderItem);
    }

    public List<OrderItem> listAll()
    {
        System.out.println("DBG: " + orderItems);
        return orderItems;
    }
}
