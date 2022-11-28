package tn.esb.storeApi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.storeApi.Entities.Product;
import tn.esb.storeApi.Services.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public ResponseEntity<?> getProducts() {
        return service.getAll();
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getOneProduct(@PathVariable  Long id) {
        return service.getProduct(id);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addOneProduct(@Valid @RequestBody Product product)
    {
        return service.addProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeOneProduct(@PathVariable Long id)
    {
        return service.deleteProduct(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOneProduct(@PathVariable Long id, @Valid @RequestBody Product product)
    {
        return service.updateProduct(id,product);
    }
}
