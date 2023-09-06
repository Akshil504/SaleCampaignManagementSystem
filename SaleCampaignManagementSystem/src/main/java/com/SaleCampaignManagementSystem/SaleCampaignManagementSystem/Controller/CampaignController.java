package com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Controller;

import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Entities.Campaign;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Model.CampaignDetails;
import com.SaleCampaignManagementSystem.SaleCampaignManagementSystem.Services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    List<Campaign> campaignList = new ArrayList<>();

    @PostMapping("/createCampaign")
    public ResponseEntity<Campaign> createCampaign(@RequestBody CampaignDetails campaign) {
        return campaignService.createCampaign(campaign);
    }

    @GetMapping("/getAll")
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }
}
