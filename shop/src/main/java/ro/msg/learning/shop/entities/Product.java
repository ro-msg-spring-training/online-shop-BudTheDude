package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;

    @Column(name = "weight")
    private double weight;

    @Column(name = "imageurl")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category")
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<Stock> stockList;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetailList;



}
