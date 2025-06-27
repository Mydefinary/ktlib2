package ktlib.domain;

import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class PreparedPublish extends AbstractEvent {

    private Long publicationId;
    private Long manuscriptId;
    private String coverUrl;
    private String genre;
    private String summary;
    private Integer readCost;
    private Date requestDate;
}
