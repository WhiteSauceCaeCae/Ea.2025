package app;

/**
 * Calculates the total, average, maximum and minimum of the product sales.
 * Sales are held in a two-dimensional array: [year][quarter].
 */
public class ProductSales implements IProduct {

    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int[] row : productSales) {
            for (int sale : row) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public double AverageSales(int[][] productSales) {
        int count = 0;
        for (int[] row : productSales) {
            count += row.length;
        }
        // Guard against division by zero for empty data
        return count == 0 ? 0 : (double) TotalSales(productSales) / count;
    }

    @Override
    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0];
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale > max) {
                    max = sale;
                }
            }
        }
        return max;
    }

    @Override
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0];
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale < min) {
                    min = sale;
                }
            }
        }
        return min;
    }
}
