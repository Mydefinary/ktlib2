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
public class BookListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private BookListRepository bookListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRequestedPublish_then_CREATE_1(
        @Payload RequestedPublish requestedPublish
    ) {
        try {
            if (!requestedPublish.validate()) return;

            // view 객체 생성
            BookList bookList = new BookList();
            // view 객체에 이벤트의 Value 를 set 함
            bookList.setManuscriptId(requestedPublish.getManuscriptId());
            bookList.setAuthorId(requestedPublish.getAuthorId());
            bookList.setTitle(requestedPublish.getTitle());
            bookList.setContent(requestedPublish.getContent());
            // view 레파지 토리에 save
            bookListRepository.save(bookList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPreparedPublish_then_UPDATE_1(
        @Payload PreparedPublish preparedPublish
    ) {
        try {
            if (!preparedPublish.validate()) return;
            // view 객체 조회

            List<BookList> bookListList = bookListRepository.findByManuscriptId(
                preparedPublish.getManuscriptId()
            );
            for (BookList bookList : bookListList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                bookList.setPublicationId(preparedPublish.getPublicationId());
                bookList.setSummary(preparedPublish.getSummary());
                bookList.setCoverUrl(preparedPublish.getCoverUrl());
                bookList.setPublicationDate(
                    String.valueOf(preparedPublish.getRequestDate())
                );
                bookList.setPrice(
                    String.valueOf(preparedPublish.getReadCost())
                );
                // view 레파지 토리에 save
                bookListRepository.save(bookList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegistedBook_then_UPDATE_2(
        @Payload RegistedBook registedBook
    ) {
        try {
            if (!registedBook.validate()) return;
            // view 객체 조회

            List<BookList> bookListList = bookListRepository.findByPublicationId(
                Long.valueOf(registedBook.getPublicationId())
            );
            for (BookList bookList : bookListList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                bookList.setBookId(registedBook.getBookId());
                bookList.setRegistrationDate(
                    registedBook.getRegistrationDate()
                );
                // view 레파지 토리에 save
                bookListRepository.save(bookList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAuthorRegistered_then_UPDATE_3(
        @Payload AuthorRegistered authorRegistered
    ) {
        try {
            if (!authorRegistered.validate()) return;
            // view 객체 조회

            List<BookList> bookListList = bookListRepository.findByAuthorId(
                authorRegistered.getAuthorId()
            );
            for (BookList bookList : bookListList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                bookList.setAuthorName(authorRegistered.getAuthorName());
                // view 레파지 토리에 save
                bookListRepository.save(bookList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
