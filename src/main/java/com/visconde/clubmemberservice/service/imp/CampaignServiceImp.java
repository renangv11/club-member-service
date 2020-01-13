package com.visconde.clubmemberservice.service.imp;

import com.visconde.clubmemberservice.datacontract.ClubMemberDataContract;
import com.visconde.clubmemberservice.service.CampaignService;
import org.springframework.stereotype.Service;

@Service
public class CampaignServiceImp implements CampaignService {
    @Override
    public void associateCampaign(ClubMemberDataContract clubMemberResponseDataContract) {
        //TODO - Lógica de postagem em tópico kafka
    }
}
