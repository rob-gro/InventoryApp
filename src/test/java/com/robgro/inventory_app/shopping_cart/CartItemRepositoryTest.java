package com.robgro.inventory_app.shopping_cart;

import com.robgro.inventory_app.product.Product;
import com.robgro.inventory_app.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class CartItemRepositoryTest {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddItemFromDatabase() {
        Product product = entityManager.find(Product.class, 10);
        User user = entityManager.find(User.class, 1);

        CartItem cartItem = new CartItem(1, product, user);

        cartItemRepository.save(cartItem);
    }

    @Test
    public void testAddItemByIds() {
        Product product = new Product(12);
        User user = new User(1);

        CartItem cartItem = new CartItem(2, product, user);

        cartItemRepository.save(cartItem);
    }

    @Test
    public void testAddMultipleItems() {
        User user = new User(2);
        Product product1 = new Product(11);
        Product product2 = new Product(12);
        Product product3 = new Product(13);

        CartItem cartItem1 = new CartItem(3, product1, user);
        CartItem cartItem2 = new CartItem(5, product2, user);
        CartItem cartItem3 = new CartItem(7, product3, user);

        cartItemRepository.saveAll(List.of(cartItem1, cartItem2, cartItem3));
    }

    @Test
    public void testListItems() {
        List<CartItem> cartItemList = cartItemRepository.findAll();
        cartItemList.forEach(System.out::println);
    }

    @Test
    public void testUpdateItem() {
        CartItem cartItem = cartItemRepository.findById(1).get();
        cartItem.setQuantity(9);
        cartItem.setProduct(new Product(13));
    }

    @Test
    public void testRemoveItem() {
        cartItemRepository.deleteById(3);
    }
}