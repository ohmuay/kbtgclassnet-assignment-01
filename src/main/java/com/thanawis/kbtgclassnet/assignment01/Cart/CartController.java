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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    @GetMapping("/cart")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Order> viewCart(@RequestHeader(name = "Authorization") String token){
        User user = userService.findByToken(token);
        return user.getCart().getOrders();
    }

    @PostMapping("/cart")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addProductToCart(@RequestHeader("Authorization") String token, @RequestBody CartRequestBody cartRequestBody){
        User user = userService.findByToken(token);
        Cart cart = user.getCart();
        Product product = productService.findById(cartRequestBody.getProductId());
        Integer quantity = cartRequestBody.getQuantity();
        Order order = orderService.createOrder(product,quantity);
        cart.addOrder(order);
        return order;
    }

    @PostMapping("/cart/checkout")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String checkoutCart(@RequestHeader("Authorization") String token){
        User user = userService.findByToken(token);
        Cart cart = user.getCart();
        String responseFromPaymentGateway =  cart.checkout();
        return responseFromPaymentGateway;
    }

}
