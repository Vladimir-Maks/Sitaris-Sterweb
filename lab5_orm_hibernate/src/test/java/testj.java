
import com.Model.Product;
import com.dao.ProductDao;
import com.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.core.LauncherFactory;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class testj {
    ProductDao productDao = Mockito.spy(ProductDao.class);


    @Test
    public void testAdd() {
        Product product1 = new Product("Барби", "Игрушка", 3, 543);
        ProductService productService = Mockito.mock(ProductService.class);
        productService.addProduct(product1);
        when(productService.findProduct("Барби")).thenReturn(product1);
        assertEquals(product1, productService.findProduct("Барби"));
    }

}

