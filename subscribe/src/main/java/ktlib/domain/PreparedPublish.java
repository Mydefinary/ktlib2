package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.infra.AbstractEvent;
import lombok.Data;

@Data
public class PreparedPublish extends AbstractEvent {

    private Long publicationID;
    private Long manuscriptID;
    private String coverUrl;
    private String genre;
    private String summary;
    private Integer readCost;
    private Date requestDate;
}
