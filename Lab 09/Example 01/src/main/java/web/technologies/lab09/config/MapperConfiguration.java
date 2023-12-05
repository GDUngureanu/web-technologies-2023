package web.technologies.lab09.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.technologies.lab09.mapper.CategoryMapper;
import web.technologies.lab09.mapper.CategoryMapperImpl;

@Configuration
public class MapperConfiguration {

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapperImpl();
    }

}
