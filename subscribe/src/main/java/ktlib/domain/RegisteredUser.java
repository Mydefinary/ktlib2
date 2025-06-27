package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.infra.AbstractEvent;
import lombok.Data;

@Data
public class RegisteredUser extends AbstractEvent {

    private Long userID;
    private String name;
    private String point;
}
