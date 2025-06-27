package ktlib.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import ktlib.config.kafka.KafkaProcessor;
import ktlib.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    SubscribeRepository subscribeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='NotDecreasedPoints'"
    )
    public void wheneverNotDecreasedPoints_FailBookSubscribe(
        @Payload NotDecreasedPoints notDecreasedPoints
    ) {
        NotDecreasedPoints event = notDecreasedPoints;
        System.out.println(
            "\n\n##### listener FailBookSubscribe : " +
            notDecreasedPoints +
            "\n\n"
        );

        // Sample Logic //
        Subscribe.failBookSubscribe(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
