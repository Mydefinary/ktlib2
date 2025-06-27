package ktlib.domain;

import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import java.util.*;
import lombok.*;
import java.time.LocalDate;


//<<< DDD / Domain Event
@Data
@ToString
public class ResisteredText extends AbstractEvent {

    private Long manuscriptId;
    private String title;
    private String content;
    private 원고 상태 status;
    private Date createdDate;
    private Long authorId;

    public ResisteredText(Manuscript aggregate){
        super(aggregate);
    }
    public ResisteredText(){
        super();
    }
}
//>>> DDD / Domain Event