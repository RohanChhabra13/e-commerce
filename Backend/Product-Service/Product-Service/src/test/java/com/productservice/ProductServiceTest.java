package com.productservice;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.capstone.ProductServiceApplication;
import com.capstone.exception.ProductAlreadyExist;
import com.capstone.exception.ProductNotFound;
import com.capstone.model.Product;
import com.capstone.repo.ProductRepository;
import com.capstone.service.ProductServiceImpl;
import junit.framework.Assert;

/**
 * Unit tests for the ProductServiceImpl class.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ProductServiceApplication.class)
public class ProductServiceTest {
	@InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);}
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.capstone.service.ProductServiceImpl#add(com.capstone.model.Product)}.
	 */
	
	@Test
    public void testAddProductNotExists() throws ProductAlreadyExist {
        // Create a sample product
        Product product = new Product();
        product.setId(1);

        // Mock the behavior of the repository to indicate that the product doesn't exist
        Mockito.when(repo.existsById(product.getId())).thenReturn(false);
        Mockito.when(repo.save(product)).thenReturn(product);

        // Test the add method
        Product result = productService.add(product);
        Assert.assertEquals(product, result);
    }
	@Test(expected = ProductAlreadyExist.class)
    public void testAddProductAlreadyExists() throws ProductAlreadyExist {
        // Create a sample product
        Product product = new Product();
        product.setId(1);

        // Mock the behavior of the repository to indicate that the product already exists
        Mockito.when(repo.existsById(product.getId())).thenReturn(true);

        // Test the add method (it should throw ProductAlreadyExist exception)
        productService.add(product);
    }
	/**
	 * Test method for {@link com.capstone.service.ProductServiceImpl#find(int)}.
	 */
	@Test
    public void testFindValidProduct() {
        // Create a sample product
        Product product = new Product();
        product.setId(1);

        // Mock the behavior of the repository to return the product when findById is called
        Mockito.when(repo.findById(product.getId())).thenReturn(Optional.of(product));

        // Test the find method
        Product result = productService.find(product.getId());
        Assert.assertEquals(product, result);
    }

    @Test(expected = ProductNotFound.class)
    public void testFindInvalidProduct() {
        // Mock the behavior of the repository to return an empty optional when findById is called
        Mockito.when(repo.findById(1)).thenReturn(Optional.empty());

        // Test the find method (it should throw ProductNotFound exception)
        productService.find(1);
    }

	/**
	 * Test method for {@link com.capstone.service.ProductServiceImpl#list()}.
	 */
    @Test
    public void testListProducts() {
        // Create sample products
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Product 1");
        product1.setCategory("Category 1");
        product1.setPrice(10.0);
        product1.setAvailable(true);
        product1.setImage("image1.jpg");

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Product 2");
        product2.setCategory("Category 2");
        product2.setPrice(20.0);
        product2.setAvailable(true);
        product2.setImage("image2.jpg");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        // Mock the behavior of the repository to return the list of products when findAll is called
        Mockito.when(repo.findAll()).thenReturn(products);

        // Test the list method
        List<Product> result = productService.list();
        Assert.assertEquals(products, result);
    }

	/**
	 * Test method for {@link com.capstone.service.ProductServiceImpl#delete(int)}.
	 */
    @Test
    public void testDeleteProduct() {
        // Create a sample product with an ID to delete
        int productIdToDelete = 1;

        // Mock the behavior of the repository to delete the product when deleteById is called
        Mockito.doNothing().when(repo).deleteById(productIdToDelete);

        // Test the delete method
        productService.delete(productIdToDelete);

        // Verify that the deleteById method was called with the correct ID
        Mockito.verify(repo).deleteById(productIdToDelete);
    }

	/**
	 * Test method for {@link com.capstone.service.ProductServiceImpl#update(com.capstone.model.Product)}.
	 */
    @Test
    public void testUpdateExistingProduct() {
        // Create a sample product
        Product product = new Product();
        product.setId(1);
        // Mock the behavior of the repository to return the product when existsById is called and to save the product when save is called
        Mockito.when(repo.existsById(product.getId())).thenReturn(true);
        Mockito.when(repo.save(product)).thenReturn(product);

        // Test the update method for an existing product
        Product result = productService.update(product);
        Assert.assertEquals(product, result);
    }

    @Test(expected = ProductNotFound.class)
    public void testUpdateNonExistingProduct() {
        // Create a sample product
        Product product = new Product();
        product.setId(1);

        // Mock the behavior of the repository to indicate that the product does not exist
        Mockito.when(repo.existsById(product.getId())).thenReturn(false);

        // Test the update method for a non-existing product (it should throw ProductNotFound exception)
        productService.update(product);
    }

	/**
	 * Test method for {@link com.capstone.service.ProductServiceImpl#listByCategory(java.lang.String)}.
	 */
    @Test
    public void testListByCategory() {
        // Create a sample category
        String category = "Category 1";

        // Create sample products with the specified category
        Product product1 = new Product();
        product1.setId(1);
        product1.setCategory(category);

        Product product2 = new Product();
        product2.setId(2);
        product2.setCategory(category);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        // Mock the behavior of the repository to return the list of products when findByCategory is called
        Mockito.when(repo.findByCategory(category)).thenReturn(products);

        // Test the listByCategory method
        List<Product> result = productService.listByCategory(category);
        Assert.assertEquals(products, result);
    }

}
