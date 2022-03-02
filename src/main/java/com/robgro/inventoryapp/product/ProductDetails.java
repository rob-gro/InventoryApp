package com.robgro.inventoryapp.product;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetails {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "value", length = 45, nullable = false)
    private String value;


    public ProductDetails(String name, String value, Product product) {
        this.product = product;
        this.name = name;
        this.value = value;
    }

    public ProductDetails() {

    }

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
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}