package webshop.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.product.util.CustomErrorType;
import webshop.product.domain.Product;
import webshop.product.service.ProductService;
import webshop.product.util.CustomMessageType;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        log.info("POST REQUEST WITH PAYLOAD: "+ product);
        productService.addProduct(product);
        return new ResponseEntity<CustomMessageType>(new CustomMessageType(true,product), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getProduct(@PathVariable String id){
        Product resultProduct = productService.getProduct(id);
        if(resultProduct != null){
            return new ResponseEntity<CustomMessageType>(new CustomMessageType(true,resultProduct),HttpStatus.OK);
        }
        return new ResponseEntity<CustomMessageType>(new CustomMessageType(false), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable String id){
        Product resultProduct = productService.updateProduct(id,product);
        if(resultProduct != null){
            return new ResponseEntity<>(new CustomMessageType(true,resultProduct),HttpStatus.OK);
        }
        return new ResponseEntity<CustomMessageType>(new CustomMessageType(false), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}/addtoStock/{quantity}")
    public  ResponseEntity<?> updateProductAddStock(@PathVariable String id, @PathVariable int quantity){
        Product resultProduct = productService.updateStock(id,quantity,"Increment");
        if(resultProduct != null){
            return new ResponseEntity<CustomMessageType>(new CustomMessageType(true,resultProduct),HttpStatus.OK);
        }
        return new ResponseEntity<CustomMessageType>(new CustomMessageType(false), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @PutMapping("/{id}/removeFromStock/{quantity}")
    public  ResponseEntity<?> updateProductMinStock( @PathVariable String id,@PathVariable int quantity){
        Product resultProduct = productService.updateStock(id,quantity,"Decrement");
        if(resultProduct != null){
            return new ResponseEntity<CustomMessageType>(new CustomMessageType(true,resultProduct),HttpStatus.OK);
        }
        return new ResponseEntity<CustomMessageType>(new CustomMessageType(false), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        boolean result = productService.removeProduct(id);
        if(result){
            return new ResponseEntity<CustomMessageType>(new CustomMessageType(true),HttpStatus.OK);
        }
        return new ResponseEntity<CustomMessageType>(new CustomMessageType(false), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/reduce")
    public ResponseEntity<?> reduceProduct(@RequestBody Map<String,Integer> productItem) {

        Boolean result = productService.reduceProduct(productItem);
        if(result){
            return new ResponseEntity<CustomMessageType>(new CustomMessageType(true),HttpStatus.OK);
        }
        return new ResponseEntity<CustomMessageType>(new CustomMessageType(false), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
