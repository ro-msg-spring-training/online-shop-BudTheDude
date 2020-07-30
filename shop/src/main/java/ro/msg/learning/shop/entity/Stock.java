package ro.msg.learning.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.embeddedid.StockID;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stock")
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @AttributeOverrides({
            @AttributeOverride(name = "locationID", column = @Column(name = "location_id")),
            @AttributeOverride(name = "productID", column = @Column(name = "product_id"))
    })

    @EmbeddedId
    private StockID stockID;

    @JsonIgnore
    @MapsId(value = "locationID")
    @ManyToOne
    private Location location;

    @JsonIgnore
    @MapsId(value = "productID")
    @ManyToOne
    private Product product;

    @Column(name = "quantity")
    private int quantity;

}
