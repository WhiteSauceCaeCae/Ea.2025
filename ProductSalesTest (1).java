package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import app.IProductSales;
import app.ProductSales;
import org.junit.jupiter.api.Test;

class ProductSalesTest {

    private final IProductSales sales = new ProductSales();

    @Test
    void GetSalesOverLimit_ReturnsNumberOfSales() {
        // 700 and 600 are above the limit of 500
        assertEquals(2, sales.GetSalesOverLimit());
    }

    @Test
    void GetSalesUnderLimit_ReturnsNumberOfSales() {
        // 300, 150, 250 and 200 are below the limit of 500
        assertEquals(4, sales.GetSalesUnderLimit());
    }
}
