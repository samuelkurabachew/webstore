package webshop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.product.CustomErrorType;
import webshop.product.domain.Product;
import webshop.product.domain.Stock;
import webshop.product.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getProduct(@PathVariable String id){
        Stock stock = productService.getProduct(id);
        if(stock != null){
            return new ResponseEntity<Stock>(stock,HttpStatus.OK);
        }
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with " + id+
                " not Found"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable String id){
        Stock stock = productService.updateProduct(id,product);
        if(stock != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with " + id+
                " not Found"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        boolean result = productService.removeProduct(id);
        if(result){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with " + id+
                " not Found"), HttpStatus.NOT_FOUND);
    }
}
