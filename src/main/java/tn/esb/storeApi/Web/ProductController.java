package tn.esb.storeApi.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.storeApi.Entities.Product;
import tn.esb.storeApi.Services.ProductService;

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
}
