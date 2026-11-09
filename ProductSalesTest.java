package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import app.IProduct;
import app.ProductSales;
import org.junit.jupiter.api.Test;

class ProductSalesTest {

    private final int[][] productSales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    private final IProduct calculator = new ProductSales();

    @Test
    void CalculateTotalSales_ReturnsTotalSales() {
        assertEquals(2200, calculator.TotalSales(productSales));
    }

    @Test
    void AverageSales_ReturnsAverageProductSales() {
        // 2200 / 6 = 366.67, displayed as 367 in the report
        assertEquals(367, calculator.AverageSales(productSales), 0.5);
    }
}
