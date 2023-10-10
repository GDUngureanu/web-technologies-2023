package web.technologies.lab01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.technologies.lab01.mapper.WandDecipher;
import web.technologies.lab01.mapper.WandDecipherImpl;
import web.technologies.lab01.mapper.WizardryMapper;
import web.technologies.lab01.mapper.WizardryMapperImpl;

@Configuration
public class HogwartsConfiguration {

    @Bean
    public WizardryMapper wizardryMapper() {
        return new WizardryMapperImpl();
    }

    @Bean
    public WandDecipher wandDecipher() {
        return new WandDecipherImpl();
    }

}
