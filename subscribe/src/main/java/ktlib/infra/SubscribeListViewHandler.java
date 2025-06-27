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
public class SubscribeListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private SubscribeListRepository subscribeListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegisteredUser_then_CREATE_1(
        @Payload RegisteredUser registeredUser
    ) {
        try {
            if (!registeredUser.validate()) return;

            // view 객체 생성
            SubscribeList subscribeList = new SubscribeList();
            // view 객체에 이벤트의 Value 를 set 함
            subscribeList.setUserId(registeredUser.getUserId());
            // view 레파지 토리에 save
            subscribeListRepository.save(subscribeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegistedBook_then_CREATE_2(
        @Payload RegistedBook registedBook
    ) {
        try {
            if (!registedBook.validate()) return;

            // view 객체 생성
            SubscribeList subscribeList = new SubscribeList();
            // view 객체에 이벤트의 Value 를 set 함
            subscribeList.setBookId(registedBook.getBookId());
            // view 레파지 토리에 save
            subscribeListRepository.save(subscribeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRequestedPublish_then_CREATE_3(
        @Payload RequestedPublish requestedPublish
    ) {
        try {
            if (!requestedPublish.validate()) return;

            // view 객체 생성
            SubscribeList subscribeList = new SubscribeList();
            // view 객체에 이벤트의 Value 를 set 함
            subscribeList.setBookTitle(requestedPublish.getTitle());
            // view 레파지 토리에 save
            subscribeListRepository.save(subscribeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookSubscribed_then_CREATE_4(
        @Payload BookSubscribed bookSubscribed
    ) {
        try {
            if (!bookSubscribed.validate()) return;

            // view 객체 생성
            SubscribeList subscribeList = new SubscribeList();
            // view 객체에 이벤트의 Value 를 set 함
            subscribeList.setSubscriptionId(bookSubscribed.getSubscriptionId());
            // view 레파지 토리에 save
            subscribeListRepository.save(subscribeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPreparedPublish_then_CREATE_5(
        @Payload PreparedPublish preparedPublish
    ) {
        try {
            if (!preparedPublish.validate()) return;

            // view 객체 생성
            SubscribeList subscribeList = new SubscribeList();
            // view 객체에 이벤트의 Value 를 set 함
            subscribeList.setBookCover(preparedPublish.getCoverUrl());
            // view 레파지 토리에 save
            subscribeListRepository.save(subscribeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
