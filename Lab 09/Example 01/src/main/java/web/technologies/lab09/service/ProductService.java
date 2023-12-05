package web.technologies.lab09.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab09.entity.Category;
import web.technologies.lab09.entity.Product;
import web.technologies.lab09.mapper.ProductMapper;
import web.technologies.lab09.repository.CategoryRepository;
import web.technologies.lab09.repository.ProductRepository;
import web.technologies.lab09.request.ProductRequest;
import web.technologies.lab09.response.ProductResponse;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequest request) {
        Set<Category> categories = request.getCategoryIds().stream()
            .map(id -> categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id)))
            .collect(Collectors.toSet());

        Product product = productMapper.toEntity(request, categories);
        product = productRepository.save(product);
        return productMapper.toResponse(product);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
            .map(productMapper::toResponse)
            .collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found for id: " + id));
        return productMapper.toResponse(product);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Set<Category> categories = request.getCategoryIds().stream()
            .map(categoryId -> categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId)))
            .collect(Collectors.toSet());

        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found for id: " + id));

        Product updatedProduct = productMapper.toEntity(request, categories);
        updatedProduct.setId(product.getId());
        productRepository.save(updatedProduct);
        return productMapper.toResponse(updatedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}


