package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Repositories;

import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, UUID> {
}
