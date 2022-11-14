package tn.esb.storeApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.storeApi.Entities.Product;
import tn.esb.storeApi.Repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAll()
    {
        return repository.findAll();
    }

    //une mauvaise implementation
    //on l'ameliore via l'utilisation de ResponseEntity
    public Product getProduct(Long id)
    {
        Optional<Product> res= repository.findById(id);
        if (res.isPresent())
            return res.get();
        return null;
    }
}
