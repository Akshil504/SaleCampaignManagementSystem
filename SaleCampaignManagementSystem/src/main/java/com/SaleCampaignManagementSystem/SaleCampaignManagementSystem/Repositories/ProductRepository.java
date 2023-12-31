package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Repositories;

import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
