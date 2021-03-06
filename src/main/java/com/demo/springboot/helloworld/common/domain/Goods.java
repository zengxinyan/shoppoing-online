package com.demo.springboot.helloworld.common.domain;

import java.math.BigDecimal;

public class Goods {
    private Integer id;

    private Integer categoryId;

    private BigDecimal no;

    private String name;

    private BigDecimal price;

    private BigDecimal disprice;

    private String description;

    private String image;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
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

    public BigDecimal getDisprice() {
        return disprice;
    }

    public void setDisprice(BigDecimal disprice) {
        this.disprice = disprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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