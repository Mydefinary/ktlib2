package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.infra.AbstractEvent;
import lombok.Data;

@Data
public class RegistedBook extends AbstractEvent {

    private Long bookID;
    private Long authorID;
    private Date registrationDate;
    private Date publicationDate;
    private Long numberOfSubscribers;
    private String publicationID;
    private String title;
}
