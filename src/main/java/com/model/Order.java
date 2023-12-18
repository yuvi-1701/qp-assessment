package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<GroceryItem> items;

    // Other attributes like order date, total amount, etc. can be added

    // Constructors, getters, and setters

    public Order() {
        // Default constructor for JPA or serialization
    }

    public Order(User user, List<GroceryItem> items) {
        this.user = user;
        this.items = items;
    }

    // Getters and setters

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

    public List<GroceryItem> getItems() {
        return items;
    }

    public void setItems(List<GroceryItem> items) {
        this.items = items;
    }
}
