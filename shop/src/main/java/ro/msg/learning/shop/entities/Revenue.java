package ro.msg.learning.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    Location location;

    @Column
    Date date;

    @Column
    long sum;
}
