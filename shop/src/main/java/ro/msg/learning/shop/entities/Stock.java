package ro.msg.learning.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import ro.msg.learning.shop.embedded_IDs.StockID;

import javax.persistence.*;

@Data
@Entity
@Table(name ="stock")
public class Stock {

    @AttributeOverrides ({
            @AttributeOverride(name = "locationID",column = @Column(name = "location")),
            @AttributeOverride(name = "productID",column = @Column(name = "product"))
    })

    @EmbeddedId
    private StockID stockID;




    @MapsId(value = "locationID")
    @ManyToOne
    private Location location;




    @MapsId(value = "productID")
    @ManyToOne
    private Product product;

    @Column(name = "quantity")
    private int quantity;

}
