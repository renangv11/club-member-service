package com.visconde.clubmemberservice.producer;

import com.visconde.clubmemberservice.datacontract.ClubMemberDataContract;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.visconde.clubmemberservice.util.MapperUtils.serializer;

@AllArgsConstructor
@Component
public class AssociateCampaignProducer {

    private static final String TOPIC = "AssociateCampaignTopic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(ClubMemberDataContract payload){
        kafkaTemplate.send(TOPIC, serializer(payload));
    }

}
