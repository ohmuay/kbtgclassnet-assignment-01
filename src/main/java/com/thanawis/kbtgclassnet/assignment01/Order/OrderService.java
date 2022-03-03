package com.thanawis.kbtgclassnet.assignment01.Order;

import com.thanawis.kbtgclassnet.assignment01.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Product product,Integer quantity){
        Order order = new Order(product,quantity);
        orderRepository.save(order);
        return order;
    }

}
