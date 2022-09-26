package tn.esb.storeApi.Web;

import org.springframework.web.bind.annotation.RestController;
import tn.esb.storeApi.Services.ProductService;

@RestController
public class ProductController {
    private ProductService productServ;
}
