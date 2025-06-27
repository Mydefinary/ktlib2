package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class UpdatedText extends AbstractEvent {

    private Long manuscriptId;
    private String title;
    private String content;
    private String status;
    private Date createdDate;
    private Date lastModified;

    public UpdatedText(Manuscript aggregate) {
        super(aggregate);
    }

    public UpdatedText() {
        super();
    }
}
//>>> DDD / Domain Event
