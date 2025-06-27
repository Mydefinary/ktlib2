package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.infra.AbstractEvent;
import lombok.Data;

@Data
public class AuthorRegistered extends AbstractEvent {

    private Long authorID;
    private String authorName;
    private String phoneNumber;
    private String email;
    private String portfolioUrl;
    private String status;
}
