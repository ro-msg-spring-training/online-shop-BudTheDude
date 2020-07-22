package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    String userName;

    @Column
    String password;

    @Column
    String emailAddress;

    @OneToMany(mappedBy = "customer")
    List<Order> orders;
}
