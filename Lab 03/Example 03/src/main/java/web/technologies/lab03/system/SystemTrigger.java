package web.technologies.lab03.system;

import java.util.Scanner;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SystemTrigger {

    @EventListener
    public void onContextRefreshed(ContextRefreshedEvent event) {
        final var context = event.getApplicationContext();
        try (final var scanner = new Scanner(System.in)) {

            final var fashionConsole = context.getBean(FashionConsole.class);
            fashionConsole.display(scanner);

            final var textileConsole = context.getBean(TextileConsole.class);
            textileConsole.display(scanner);
        }
    }

}
