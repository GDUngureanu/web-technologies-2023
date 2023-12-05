package web.technologies.lab09.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab09.entity.Category;
import web.technologies.lab09.mapper.CategoryMapper;
import web.technologies.lab09.repository.CategoryRepository;
import web.technologies.lab09.request.CategoryRequest;
import web.technologies.lab09.response.CategoryResponse;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryResponse createCategory(CategoryRequest request) {
        Category entry = categoryMapper.toEntry(request);
        return categoryMapper.toResponse(categoryRepository.save(entry));
    }

    public List<CategoryResponse> getAllCategories() {
        return categoryMapper.toResponse(categoryRepository.findAll());
    }

    public CategoryResponse getCategoryById(Long id) {
        return categoryMapper.toResponse(findCategoryById(id));
    }

    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        Category category = findCategoryById(id);
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


    private Category findCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new RuntimeException("Category not found for id: " + id);
        }
    }
}
