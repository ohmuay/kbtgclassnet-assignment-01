package com.thanawis.kbtgclassnet.assignment01.Cart;


import com.thanawis.kbtgclassnet.assignment01.Order.Order;
import com.thanawis.kbtgclassnet.assignment01.Order.OrderService;
import com.thanawis.kbtgclassnet.assignment01.Product.Product;
import com.thanawis.kbtgclassnet.assignment01.Product.ProductRepository;
import com.thanawis.kbtgclassnet.assignment01.Product.ProductService;
import com.thanawis.kbtgclassnet.assignment01.User.User;
import com.thanawis.kbtgclassnet.assignment01.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Transactional
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping("/cart")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductToCart(@RequestHeader("Authorization") String token, @RequestBody CartRequestBody cartRequestBody){
        User user = userService.findByToken(token);
        Cart cart = user.getCart();
        Product product = productService.findById(cartRequestBody.getProductId());
        Integer quantity = cartRequestBody.getQuantity();
        Order order = orderService.createOrder(product,quantity);
        cart.addOrder(order);
    }

}
