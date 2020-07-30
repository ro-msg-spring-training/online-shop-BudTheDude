package ro.msg.learning.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "revenue")
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Location location;

    @Column(name = "date")
    private Date date;

    @Column(name = "sum")
    private long sum;
}
