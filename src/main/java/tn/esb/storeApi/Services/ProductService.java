package tn.esb.storeApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.storeApi.Repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepos;
}
