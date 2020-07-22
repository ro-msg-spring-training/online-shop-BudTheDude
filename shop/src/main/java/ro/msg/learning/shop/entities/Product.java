package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String name;

    @Column
    String description;

    @Column
    long price;

    @Column
    double weight;

    @ManyToOne
    private ProductCategory category;

    @ManyToOne
    private Supplier supplier;



}
