package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Services;

import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.*;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Model.CampaignDetails;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Model.CampaignDiscount;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Repositories.CampaignRepository;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Repositories.PriceHistoryRepository;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CampaignService {
    @Autowired
    private ProductService productService;

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private ProductRepository productRepository;

    List<CampaignDiscount> campaignDiscountList;
        public ResponseEntity<Campaign> createCampaign(CampaignDetails campaignDetails) {
        Campaign campaign = new Campaign();
        List<CampaignDiscount> campaignDiscounts = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for (Product product : productList) campaignDiscounts.add(CampaignDiscount.builder().productId(product.getId()).discount(product.getDiscount()).build());

        try {
            for (CampaignDiscount discount : campaignDiscounts) {
                UUID productId = discount.getProductId();
                double discountValue = discount.getDiscount();

                Product product = productService.getProductById(productId);

                if (product != null) {
                    double currentPrice = product.getCurrentPrice();
                    double discountAmount = (currentPrice * discountValue) / 100;
                    double newPrice = currentPrice - discountAmount;

                    product.setCurrentPrice(newPrice);

                    productService.updateProduct(product);

                    PriceHistory pricingHistory = PriceHistory.builder()
                            .productId(productId)
                            .oldPrice(currentPrice)
                            .newPrice(newPrice)
                            .build();
                    priceHistoryRepository.save(pricingHistory);
                }
                campaign = campaignRepository.save(Campaign.builder()
                        .id(UUID.randomUUID())
                        .startDate(campaignDetails.getStartDate())
                        .endDate(campaignDetails.getEndDate())
                        .title(campaignDetails.getTitle())
                        .pId(productId)
                        .build());
            }
            return new ResponseEntity<>(campaign,HttpStatus.CREATED);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(campaign,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
}
