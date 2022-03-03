package com.thanawis.kbtgclassnet.assignment01.Cart;


import com.thanawis.kbtgclassnet.assignment01.Order.Order;
import com.thanawis.kbtgclassnet.assignment01.User.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart_table")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    private User user;


    @ManyToMany
    private List<Order> orders = new ArrayList<>();

    public Cart(){};

    public Cart(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }
}
