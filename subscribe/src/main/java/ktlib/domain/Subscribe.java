package ktlib.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlib.SubscribeApplication;
import ktlib.domain.BookSubscribed;
import ktlib.domain.CanceldBookSubscribe;
import lombok.Data;

@Entity
@Table(name = "Subscribe_table")
@Data
//<<< DDD / Aggregate Root
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionId;

    private Long bookId;

    private Long userId;

    private Date subscribedAt;

    private Date expriedAt;

    private Date paymentAt;

    private Boolean paymentSuccess;

    private Integer readCost;

    @PostPersist
    public void onPostPersist() {
        BookSubscribed bookSubscribed = new BookSubscribed(this);
        bookSubscribed.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        CanceldBookSubscribe canceldBookSubscribe = new CanceldBookSubscribe(
            this
        );
        canceldBookSubscribe.publishAfterCommit();
    }

    public static SubscribeRepository repository() {
        SubscribeRepository subscribeRepository = SubscribeApplication.applicationContext.getBean(
            SubscribeRepository.class
        );
        return subscribeRepository;
    }

    //<<< Clean Arch / Port Method
    public static void failBookSubscribe(
        NotDecreasedPoints notDecreasedPoints
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscribe subscribe = new Subscribe();
        repository().save(subscribe);

        */

        /** Example 2:  finding and process
        

        repository().findById(notDecreasedPoints.get???()).ifPresent(subscribe->{
            
            subscribe // do something
            repository().save(subscribe);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
