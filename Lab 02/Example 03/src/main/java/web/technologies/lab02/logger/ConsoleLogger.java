package web.technologies.lab02.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsoleLogger implements ActionLogger {

    @Override
    public void log(String message) {
        log.info(message);
    }

}
