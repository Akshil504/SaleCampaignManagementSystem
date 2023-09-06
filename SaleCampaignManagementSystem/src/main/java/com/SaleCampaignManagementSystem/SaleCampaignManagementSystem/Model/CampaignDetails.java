package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CampaignDetails {
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;

    List<CampaignDiscount> campaignDiscountList;
}
