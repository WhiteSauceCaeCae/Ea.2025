package app;

/**
 * Processes product sales data for the sound equipment retailer.
 * Sales are stored as [year][product] where the products are
 * Microphone, Speakers and Mixing Desk.
 */
public class ProductSales implements IProductSales {

    public static final int SALES_LIMIT = 500;

    private final int[][] productSales = {
        {300, 150, 700},   // Sales for year 1
        {250, 200, 600}    // Sales for year 2
    };

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public int GetSalesOverLimit() {
        return countSales(true);
    }

    @Override
    public int GetSalesUnderLimit() {
        return countSales(false);
    }

    @Override
    public int GetProductsProcessed() {
        // Number of years for which sales have been processed
        return productSales.length;
    }

    @Override
    public double GetAverageSales() {
        int count = 0;
        for (int[] year : productSales) {
            count += year.length;
        }
        return count == 0 ? 0 : (double) GetTotalSales() / count;
    }

    // Counts sales above the limit (over = true) or below it (over = false)
    private int countSales(boolean over) {
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (over ? sale > SALES_LIMIT : sale < SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }
}
