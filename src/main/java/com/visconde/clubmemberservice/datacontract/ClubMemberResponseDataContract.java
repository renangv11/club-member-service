package com.visconde.clubmemberservice.datacontract;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.visconde.clubmemberservice.gateway.CampaignDataContract;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClubMemberResponseDataContract {

    @JsonProperty("socio_torcedor")
    private ClubMemberDataContract clubMemberDataContract;

    @JsonProperty("campanhas")
    private List<CampaignDataContract> campaigns;

}
