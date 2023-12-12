package web.technologies.lab10.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anySet;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import web.technologies.lab10.entity.Category;
import web.technologies.lab10.entity.Product;
import web.technologies.lab10.mapper.ProductMapper;
import web.technologies.lab10.repository.CategoryRepository;
import web.technologies.lab10.repository.ProductRepository;
import web.technologies.lab10.request.ProductRequest;
import web.technologies.lab10.response.ProductResponse;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    private ProductRequest productRequest;
    private Product product;
    private ProductResponse productResponse;
    private Category category;

    @BeforeEach
    void setUp() {
        // Setup test data
        productRequest = new ProductRequest();
        productRequest.setName("Sample Product");
        productRequest.setDescription("Sample Description");
        productRequest.setPrice(100.0);
        productRequest.setCategoryIds(new HashSet<>(List.of(1L)));

        category = new Category();
        category.setId(1L);
        category.setName("Category 1");
        category.setDescription("Category Description");

        Set<Category> categories = new HashSet<>();
        categories.add(category);

        product = new Product();
        product.setId(1L);
        product.setName("Sample Product");
        product.setDescription("Sample Description");
        product.setPrice(100.0);
        product.setCategories(categories);

        productResponse = new ProductResponse();
        productResponse.setId(1L);
        productResponse.setName("Sample Product");
        productResponse.setDescription("Sample Description");
        productResponse.setPrice(100.0);
        Set<String> categoryNames = new HashSet<>();
        categoryNames.add("Category 1");
        productResponse.setCategories(categoryNames);
    }

    @Test
    void createProductTest_NormalFlow() {
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        when(productMapper.toEntity(any(ProductRequest.class), anySet())).thenReturn(product);
        when(productMapper.toResponse(any(Product.class))).thenReturn(productResponse);

        ProductResponse response = productService.createProduct(productRequest);

        assertNotNull(response);
        assertEquals(product.getId(), response.getId());
        verify(productRepository, times(1)).save(any(Product.class));
        verify(categoryRepository, times(1)).findById(anyLong());
    }

    @Test
    void createProductTest_CategoryNotFound() {
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.createProduct(productRequest);
        });

        assertEquals("Category not found with id: 1", exception.getMessage());
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    void getAllProductsTest() {
        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
        when(productMapper.toResponse(any(Product.class))).thenReturn(productResponse);

        List<ProductResponse> responses = productService.getAllProducts();

        assertFalse(responses.isEmpty());
        assertEquals(1, responses.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void getProductByIdTest_NormalFlow() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));
        when(productMapper.toResponse(any(Product.class))).thenReturn(productResponse);

        ProductResponse response = productService.getProductById(1L);

        assertNotNull(response);
        assertEquals(product.getId(), response.getId());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void getProductByIdTest_NotFound() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.getProductById(1L);
        });

        assertEquals("Product not found for id: 1", exception.getMessage());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void updateProductTest_NormalFlow() {
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        when(productMapper.toEntity(any(ProductRequest.class), anySet())).thenReturn(product);
        when(productMapper.toResponse(any(Product.class))).thenReturn(productResponse);

        ProductResponse response = productService.updateProduct(1L, productRequest);

        assertNotNull(response);
        assertEquals(product.getId(), response.getId());
        verify(productRepository, times(1)).save(any(Product.class));
        verify(productRepository, times(1)).findById(1L);
        verify(categoryRepository, times(1)).findById(anyLong());
    }

    @Test
    void updateProductTest_ProductNotFound() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.updateProduct(1L, productRequest);
        });

        assertEquals("Product not found for id: 1", exception.getMessage());
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    void deleteProductTest() {
        doNothing().when(productRepository).deleteById(anyLong());

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}
