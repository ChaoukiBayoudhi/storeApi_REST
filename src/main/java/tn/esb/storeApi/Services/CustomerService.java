package tn.esb.storeApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.storeApi.Repositories.CustomRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomRepository repository;
}
