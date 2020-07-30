package ro.msg.learning.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "street_Address")
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
