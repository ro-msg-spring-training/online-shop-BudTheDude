package ro.msg.learning.shop.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @Column(name = "street_address")
    private String streetAddress;


    @OneToMany(mappedBy = "shippedFrom")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Order> orders;


    @OneToMany(mappedBy = "location")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Revenue> revenues;


    @OneToMany(mappedBy = "location")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Stock> stockList;

}
