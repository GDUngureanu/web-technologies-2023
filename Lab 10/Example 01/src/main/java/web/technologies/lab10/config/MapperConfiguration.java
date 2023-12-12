package web.technologies.lab10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.technologies.lab10.mapper.CategoryMapper;
import web.technologies.lab10.mapper.CategoryMapperImpl;

@Configuration
public class MapperConfiguration {

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapperImpl();
    }

}
