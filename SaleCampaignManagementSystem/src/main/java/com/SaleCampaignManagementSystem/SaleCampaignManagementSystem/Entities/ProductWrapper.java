package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWrapper {

    private List<Product> productList;
    private Integer page;
    private Integer pageSize;
    private Integer totalPages;

}
