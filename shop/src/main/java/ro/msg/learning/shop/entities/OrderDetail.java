package ro.msg.learning.shop.entities;

import ro.msg.learning.shop.embedded_IDs.OrderDetailID;

import javax.persistence.*;

@Entity
public class OrderDetail {

    @AttributeOverrides({
            @AttributeOverride(name = "orderID",column = @Column(name = "order")),
            @AttributeOverride(name = "productID",column = @Column(name = "product"))
    })

    @EmbeddedId
    OrderDetailID orderDetailID;

    @MapsId("orderID")
    @ManyToOne
    private Order order;

    @MapsId("productID")
    @ManyToOne
    private Product product;


}
