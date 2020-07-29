package ro.msg.learning.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.repositories.SupplierRepository;

@Service
@AllArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public Supplier getByID(int id){
        return supplierRepository.findById(id).get();
    }
}
