package com.capstone;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.capstone.entity.Cart;
import com.capstone.repo.CartRepository;
import com.capstone.service.CartServiceImpl;
import com.capstone.vo.CartTemplate;
import com.capstone.vo.Product;

public class CartServiceTest {

    @InjectMocks
    private CartServiceImpl cartService;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdd() {
        Cart cart = new Cart();
        when(cartRepository.save(cart)).thenReturn(cart);

        Cart addedCart = cartService.add(cart);

        assertEquals(cart, addedCart);
    }

    @Test
    public void testDelete() {
        int cartId = 1;
        doNothing().when(cartRepository).deleteById(cartId);

        cartService.delete(cartId);

        verify(cartRepository, times(1)).deleteById(cartId);
    }

    @Test
    public void testList() {
        String customerId = "customer1";
        List<Cart> carts = new ArrayList<>();
        when(cartRepository.findByCustid(customerId)).thenReturn(carts);

        List<Product> products = new ArrayList<>();
        // Populate the products list with sample data

        ResponseEntity<List<Product>> productResponse = new ResponseEntity<>(products, null, 200);

        when(restTemplate.exchange(
                eq("http://localhost:9001/product/all"),
                eq(HttpMethod.GET),
                eq(null),
                any(ParameterizedTypeReference.class)
            )).thenReturn(productResponse);

        List<CartTemplate> cartTemplates = cartService.list(customerId);

        // Add your assertions here to validate the results
    }
}
