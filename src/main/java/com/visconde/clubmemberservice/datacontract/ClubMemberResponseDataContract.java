package com.visconde.clubmemberservice.datacontract;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.visconde.clubmemberservice.gateway.CampaignDataContract;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClubMemberResponseDataContract {

    @JsonProperty("socio_torcedor")
    private ClubMemberDataContract clubMemberDataContract;

    @JsonProperty("campanhas")
    private List<CampaignDataContract> campaigns;

}
