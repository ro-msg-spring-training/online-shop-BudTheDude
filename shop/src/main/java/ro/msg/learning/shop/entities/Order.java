package ro.msg.learning.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order1")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @JsonIgnore
    @ManyToOne
    private Location shippedFrom;


    @JsonIgnore
    @ManyToOne
    private Customer customer;

    @Column(name = "created_At")
    private String createdAt;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county;

    @Column(name = "street_Address")
    private String streetAddress;


    @JsonIgnore
    @OneToMany(mappedBy = "order")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<OrderDetail> orderDetailList;
}
