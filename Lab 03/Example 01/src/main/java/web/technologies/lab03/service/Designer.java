package web.technologies.lab03.service;

import java.util.UUID;

import web.technologies.lab03.model.Design;

public class Designer {

    public Design sketch(final String type, final String designDetails) {
        return new Design(UUID.randomUUID(), type, designDetails);
    }

}
