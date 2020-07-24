package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Location shippedFrom;

    @ManyToOne
    private Customer customer;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @Column(name = "streetAddress")
    private String streetAddress;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList;
}
