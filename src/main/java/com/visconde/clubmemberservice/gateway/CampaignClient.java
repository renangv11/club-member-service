package com.visconde.clubmemberservice.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "${urlCampaign}")
public interface CampaignClient {
    @GetMapping("/campanha")
    List<CampaignDataContract> getCampaignsByTeamName(@RequestParam("nome_time") String teamName);
}
