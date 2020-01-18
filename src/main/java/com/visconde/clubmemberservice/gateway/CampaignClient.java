package com.visconde.clubmemberservice.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "localhost:8080")
public interface CampaignClient {
    @GetMapping("/campanha")
    List<CampaignDataContract> getCampaignByUserId(@RequestParam("id_socio") Long id);
}
