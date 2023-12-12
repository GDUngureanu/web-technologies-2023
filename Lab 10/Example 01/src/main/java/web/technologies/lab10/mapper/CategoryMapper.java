package web.technologies.lab10.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import web.technologies.lab10.entity.Category;
import web.technologies.lab10.request.CategoryRequest;
import web.technologies.lab10.response.CategoryResponse;

@Mapper
public interface CategoryMapper {

    List<CategoryResponse> toResponse(List<Category> entities);

    CategoryResponse toResponse(Category entry);

    Category toEntry(CategoryRequest request);

}
