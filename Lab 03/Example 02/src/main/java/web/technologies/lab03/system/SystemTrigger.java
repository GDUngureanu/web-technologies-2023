package web.technologies.lab03.system;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SystemTrigger {

    @Autowired
    private FashionConsole fashionConsole;

    @Autowired
    private TextileConsole textileConsole;

    @EventListener
    public void onContextRefreshed(ContextRefreshedEvent event) {
        try (final var scanner = new Scanner(System.in)) {
            fashionConsole.display(scanner);
            textileConsole.display(scanner);
        }
    }

}
