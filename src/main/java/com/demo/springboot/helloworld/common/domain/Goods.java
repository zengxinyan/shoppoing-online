package com.demo.springboot.helloworld.common.domain;

import java.math.BigDecimal;

public class Goods {
    private Integer id;

    private String name;

    private BigDecimal price;

    private String description;

    private String category;

    private Integer onsale;

    private Integer sold;

    private Boolean ishot;

    private Boolean isdiscount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getOnsale() {
        return onsale;
    }

    public void setOnsale(Integer onsale) {
        this.onsale = onsale;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Boolean getIshot() {
        return ishot;
    }

    public void setIshot(Boolean ishot) {
        this.ishot = ishot;
    }

    public Boolean getIsdiscount() {
        return isdiscount;
    }

    public void setIsdiscount(Boolean isdiscount) {
        this.isdiscount = isdiscount;
    }
}