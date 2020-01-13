package com.visconde.clubmemberservice.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "test")
public interface CampaignClient {
    @GetMapping
    List<CampaignDataContract> getCampaignByUserId(Long id);
}
