package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Controller;

import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.PriceHistory;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.Product;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.ProductWrapper;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.Response;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    List<Product> productList = new ArrayList<>();
    @GetMapping("/product")
    public List<Product> getProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {

        return productService.getProducts(page, pageSize);
    }

    @PostMapping("/createOne")
    public ResponseEntity<Response> createProduct(@RequestBody String productString) {
        return this.productService.createProduct(productString);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/{productId}/adjust-price")
    public Product adjustProductPrice(@PathVariable UUID productId, @RequestParam double discount) {
        return productService.adjustProductPrice(productId, discount);
    }

    @GetMapping("/getAllPaginationProducts")
    public ProductWrapper getAllPaginationProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
            return productService.getAllPaginationProducts(page,pageSize);
    }

    @GetMapping("/getAllPriceHistory")
    public List<PriceHistory> getPriceHistory() {
        return productService.getPriceHistory();
    }
}
