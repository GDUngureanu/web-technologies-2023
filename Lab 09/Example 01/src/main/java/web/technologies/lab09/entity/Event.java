package web.technologies.lab09.entity;

import java.util.Date;
import java.util.Set;

public class Event {

    private Long id;
    private String eventName;
    private String description;
    private Date eventDate;
    private Set<Customer> participants;

}

