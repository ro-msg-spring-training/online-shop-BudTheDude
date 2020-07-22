package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    Location shippedFrom;

    @ManyToOne
    Customer customer;

    @Column
    Date createdAt;

    @Column
    String country;

    @Column
    String city;

    @Column
    String county;

    @Column
    String streetAddress;
}
