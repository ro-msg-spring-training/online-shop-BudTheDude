package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.entities.Location;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {



}