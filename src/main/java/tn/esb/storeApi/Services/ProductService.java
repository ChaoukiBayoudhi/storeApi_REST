package tn.esb.storeApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.storeApi.Entities.Product;
import tn.esb.storeApi.Entities.Provider;
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
    //1ère méthode
    public ResponseEntity<?> addProduct(Product product)
    {
        //recuperer tous les produits
        List<Product> res= repository.findAll();
        //chercher s'il existe un produit ayant le meme nom dejà dans la BD.
        int i=0;
        boolean found= false;
        while(i<res.size() && !found)
        {
            if(res.get(i).getName().equalsIgnoreCase(product.getName()))
                found=true;
            else
                i++;
        }
        Product p;
        if(!found) //ajouter le nouveau produit
        {
            p=repository.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
        //si le produit existe, on augmente juste le stock
        int oldStock=res.get(i).getStock();
        res.get(i).setStock(oldStock+ product.getStock());
        //mise à jour du produit dans la base de données
        p=repository.save(res.get(i));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(p);
    }

    public ResponseEntity<?> deleteProduct(Long id)
    {
        Optional<Product> res= repository.findById(id);
        if (res.isEmpty())
            return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    public ResponseEntity<?> updateProduct(Long id,Product newProduct)
    {
        Optional<Product> res= repository.findById(id);
        if (res.isEmpty())
            //return ResponseEntity.notFound().build();
            //ou bien
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no such product with id = " + id);
        Product p=res.get();//recupere le produit pour le modifier
        //mise a jour des differents champs du produit
        p.setName(newProduct.getName());
        p.setDescription(newProduct.getDescription());
        p.setPrice(newProduct.getPrice());
        p.setStock(newProduct.getStock());
        p.setFabricationDate(newProduct.getFabricationDate());
        p.setExpirationDate(newProduct.getExpirationDate());
        //mise à jour du provider
        Provider pv=newProduct.getProductProvider();
        if(pv!=null) {
            p.getProductProvider().setName(pv.getName());
            p.getProductProvider().setEmail(pv.getEmail());
            p.getProductProvider().setTelephoneNumber(pv.getTelephoneNumber());
            //...
        }

        repository.save(p);//update product instance on the database
        //return ResponseEntity.accepted().build();
        //ou bien
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(p);
    }
}
