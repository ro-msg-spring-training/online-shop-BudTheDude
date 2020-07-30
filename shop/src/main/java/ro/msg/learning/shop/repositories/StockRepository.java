package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {

    @Query("SELECT s FROM Stock s WHERE " +
            "s.quantity = (SELECT max(s2.quantity) FROM Stock s2 WHERE s2.stockID.productID= :loc) ")
    Stock getMaxQuantity(@Param("loc") Integer loc);

    @Query("SELECT s FROM Stock s WHERE s.stockID.productID= :prod AND s.stockID.locationID= :loc")
    Stock findByProductAndAndLocation(@Param("prod") Integer prod, @Param("loc") Integer loc);
}
