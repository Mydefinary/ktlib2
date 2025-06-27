package ktlib.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import ktlib.config.kafka.KafkaProcessor;
import ktlib.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ManuscriptListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ManuscriptListRepository manuscriptListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenResisteredText_then_CREATE_1(
        @Payload ResisteredText resisteredText
    ) {
        try {
            if (!resisteredText.validate()) return;

            // view 객체 생성
            ManuscriptList manuscriptList = new ManuscriptList();
            // view 객체에 이벤트의 Value 를 set 함
            manuscriptList.setManuscriptId(resisteredText.getManuscriptId());
            manuscriptList.setTitle(resisteredText.getTitle());
            manuscriptList.setContent(resisteredText.getContent());
            manuscriptList.setStatus(
                String.valueOf(resisteredText.getStatus())
            );
            manuscriptList.setCreatedDate(resisteredText.getCreatedDate());
            manuscriptList.setLastModified(resisteredText.getCreatedDate());
            // view 레파지 토리에 save
            manuscriptListRepository.save(manuscriptList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUpdatedText_then_UPDATE_1(
        @Payload UpdatedText updatedText
    ) {
        try {
            if (!updatedText.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
