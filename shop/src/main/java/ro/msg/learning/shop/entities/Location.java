package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String name;

    @Column
    String country;

    @Column
    String city;

    @Column
    String county;

    @Column
    String streetAddress;

    @OneToMany(mappedBy = "shippedFrom")
    List<Order> orders;

    @OneToMany(mappedBy = "location")
    List<Revenue> revenues;

}
