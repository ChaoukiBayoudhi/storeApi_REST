package tn.esb.storeApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.storeApi.Entities.Product;
import tn.esb.storeApi.Repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    public ResponseEntity<?> getAll() {
        List<Product> res=repository.findAll();
        if(res.isEmpty())
            //return ResponseEntity.noContent().build();
            //or
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There are no products available");
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    //une mauvaise implementation
    //on l'ameliore via l'utilisation de ResponseEntity
    public ResponseEntity<?> getProduct(Long id)
    {
        Optional<Product> res= repository.findById(id);
        if (res.isPresent())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(res.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no product available with id = " + id);
    }
}
