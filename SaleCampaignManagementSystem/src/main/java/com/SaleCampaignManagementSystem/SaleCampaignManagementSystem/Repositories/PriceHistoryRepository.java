package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Repositories;

import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, UUID> {
}
