package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Services;

import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.PriceHistory;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.Product;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.ProductWrapper;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.Response;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Repositories.PriceHistoryRepository;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Repositories.ProductRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;
    List<Product> products;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProducts(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        Page<Product> getAllProducts = productRepository.findAll(pageable);
        products = getAllProducts.getContent();
        return products;
    }

    public Product adjustProductPrice(UUID productId, double discount) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            double currentPrice = product.getMrp() - (product.getMrp() * discount / 100);
            product.setCurrentPrice(currentPrice);
            product.setDiscount(discount);
            productRepository.save(product);
        }
        return product;
    }


    public ResponseEntity<Response> createProduct(String productString) {
        Response response = new Response();
        ResponseEntity<Response> responseResponseEntity = null;
        try {
            Gson gson = new Gson();
            Product product = gson.fromJson(productString, Product.class);
            Product savedproduct = productRepository.save(product);
            response.setBody(gson.toJson(savedproduct));
            response.setMessage("Product Created");
            responseResponseEntity = new ResponseEntity<>(response,HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return responseResponseEntity;
    }

    public ProductWrapper getAllPaginationProducts(int page, int pageSize) {
//        int totalProducts = products.size();
//        int totalPages = (int) Math.ceil((double) totalProducts/pageSize);
//        int startIndex = (page - 1) * pageSize;
//        int endIndex = Math.min(startIndex + pageSize,totalProducts);
//        List<Product> productsOnPage = products.subList(startIndex,endIndex);
//        return new ProductWrapper(productsOnPage,page,pageSize,totalPages);
        Page<Product> productPage = productRepository.findAll(PageRequest.of(page - 1,pageSize));
        List<Product> productsOnPage = productPage.getContent();
        int totalPages = productPage.getTotalPages();
        return new ProductWrapper(productsOnPage,page,pageSize,totalPages);
    }

    public Product getProductById(UUID productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    public void updateProduct(Product product) {
        String productId = String.valueOf(product.getId());
        if (productRepository.existsById(UUID.fromString(productId))) {
            productRepository.save(product);
        }
    }

    public List<PriceHistory> getPriceHistory() {
        return priceHistoryRepository.findAll();
    }
}
