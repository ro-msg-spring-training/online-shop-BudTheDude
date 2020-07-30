package ro.msg.learning.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.embeddedid.OrderDetailID;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {

    @AttributeOverrides({
            @AttributeOverride(name = "orderID", column = @Column(name = "order_id")),
            @AttributeOverride(name = "productID", column = @Column(name = "product_id"))
    })

    @EmbeddedId
    private OrderDetailID orderDetailID;

    @MapsId("orderID")
    @ManyToOne
    private Order order;

    @MapsId("productID")
    @ManyToOne
    private Product product;

    @Column(name = "quantity")
    private int quantity;


}
