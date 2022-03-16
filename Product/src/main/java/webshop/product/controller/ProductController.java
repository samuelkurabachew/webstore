package webshop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.product.util.CustomErrorType;
import webshop.product.domain.Product;
import webshop.product.service.ProductService;

import java.util.Map;

@RestController
@RequestMapping("/product")
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
        Product resultProduct = productService.getProduct(id);
        if(resultProduct != null){
            return new ResponseEntity<Product>(resultProduct,HttpStatus.OK);
        }
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with " + id+
                " not Found"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable String id){
        Product resultProduct = productService.updateProduct(id,product);
        if(resultProduct != null){
            return new ResponseEntity<>("Product updated Successfully!!!",HttpStatus.OK);
        }
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with " + id+
                " not Found"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/addtoStock/{quantity}")
    public  ResponseEntity<?> updateProductAddStock(@PathVariable String id, @PathVariable int quantity){
        boolean result = productService.updateStock(id,quantity,"Increment");
        if(result){
            return new ResponseEntity<>("Product added Successfully to Stock",HttpStatus.OK);
        }
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with " + id+
                " not Found"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/removeFromStock/{quantity}")
    public  ResponseEntity<?> updateProductMinStock( @PathVariable String id,@PathVariable int quantity){
        boolean result = productService.updateStock(id,quantity,"Decrement");
        if(result){
            return new ResponseEntity<>("Remove Product Successful",HttpStatus.OK);
        }
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with " + id+
                " not Available"), HttpStatus.NOT_FOUND);
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

    @PutMapping("/reduce")
    public ResponseEntity<?> reduceProduct(@RequestBody Map<String,Integer> productItem) {

        Boolean result = productService.reduceProduct(productItem);
        if(result){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Not Successful"), HttpStatus.NOT_FOUND);
    }
}
