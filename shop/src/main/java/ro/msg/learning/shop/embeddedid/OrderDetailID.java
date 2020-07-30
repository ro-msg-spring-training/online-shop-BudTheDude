package ro.msg.learning.shop.embeddedid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailID implements Serializable {

    @Column
    private int orderID;

    @Column
    private int productID;
}
