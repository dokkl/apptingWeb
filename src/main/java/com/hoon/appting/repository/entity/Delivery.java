package com.hoon.appting.repository.entity;

import javax.persistence.*;

/**
 * Created by hoon on 2015-04-06.
 */
@Entity
@Table(name="delivery")
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId" , nullable=false, insertable=true, updatable=false)
    private  User user;

    private Long productId;

    private String address;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
