package webshop.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.product.domain.Product;

@RestController
@RequestMapping("product")
public class ProductController {

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product){

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getProduct(@PathVariable String id){

        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateProduct(@PathVariable String id){
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
