package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities;

import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Model.CampaignDiscount;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private UUID pId;

}
