package tn.esb.storeApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.storeApi.Entities.Customer;
@Repository
public interface CustomRepository extends JpaRepository<Customer,Long> {
}
