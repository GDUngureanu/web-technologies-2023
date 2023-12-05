package web.technologies.lab09.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import web.technologies.lab09.entity.Category;
import web.technologies.lab09.request.CategoryRequest;
import web.technologies.lab09.response.CategoryResponse;

@Mapper
public interface CategoryMapper {

    List<CategoryResponse> toResponse(List<Category> entities);

    CategoryResponse toResponse(Category entry);

    Category toEntry(CategoryRequest request);

}
