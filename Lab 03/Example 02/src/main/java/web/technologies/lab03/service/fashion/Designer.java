package web.technologies.lab03.service.fashion;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import web.technologies.lab03.model.fashion.Design;

@Service
@RequiredArgsConstructor
public class Designer {

    private final ApplicationContext context;

    public Design sketch(final String type, final String design) {
        return context.getBean(Design.class, type, design);
    }

}
