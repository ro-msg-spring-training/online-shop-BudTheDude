package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    @Column
    String name;

    @OneToMany(mappedBy = "supplier")
    List<Product> products;
}
