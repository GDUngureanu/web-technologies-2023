package web.technologies.lab02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.technologies.lab02.logger.ActionLogger;
import web.technologies.lab02.logger.ConsoleLogger;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ActionLogger consoleLogger() {
        return new ConsoleLogger();
    }

}
