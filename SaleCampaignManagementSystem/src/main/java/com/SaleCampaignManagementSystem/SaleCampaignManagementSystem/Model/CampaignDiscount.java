package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampaignDiscount {

    private UUID productId;
    private double discount;
}
