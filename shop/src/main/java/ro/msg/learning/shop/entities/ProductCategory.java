package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String name;

    @Column
    String description;

    @OneToMany(mappedBy = "category")
    List<Product> products;
}
