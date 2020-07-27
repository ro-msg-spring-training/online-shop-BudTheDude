package ro.msg.learning.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import ro.msg.learning.shop.embedded_IDs.StockID;

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

    @Column(name = "streetAddress")
    private String streetAddress;


    @OneToMany(mappedBy = "shippedFrom")
    private List<Order> orders;


    @OneToMany(mappedBy = "location")
    private List<Revenue> revenues;


    @OneToMany(mappedBy = "location")
    private List<Stock> stockList;

}
