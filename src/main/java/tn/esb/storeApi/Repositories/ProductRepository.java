package tn.esb.storeApi.Repositories;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.storeApi.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
