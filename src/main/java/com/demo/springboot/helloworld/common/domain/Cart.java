package com.demo.springboot.helloworld.common.domain;

import com.demo.springboot.helloworld.common.domain.extend.CartExtend;

import java.math.BigDecimal;

public class Cart extends CartExtend {
    private Integer id;

    private Integer userId;

    private Integer quantity;

    private BigDecimal total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}