package app;

public class Main {

    public static void main(String[] args) {
        // Rows = years, columns = quarters
        int[][] productSales = {
            {300, 150, 700},   // Year 1
            {250, 200, 600}    // Year 2
        };

        IProduct calculator = new ProductSales();

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("-----------------------------------");
        System.out.printf("%-10s %10s %10s %10s%n", "", "QUARTER 1", "QUARTER 2", "QUARTER 3");

        // Print every row (year) and column (quarter) of the sales data
        for (int year = 0; year < productSales.length; year++) {
            System.out.printf("%-10s", "YEAR " + (year + 1));
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                System.out.printf(" %10d", productSales[year][quarter]);
            }
            System.out.println();
        }

        System.out.println("-----------------------------------");
        System.out.println("Total sales:   " + calculator.TotalSales(productSales));
        System.out.printf("Average sales: %.0f%n", calculator.AverageSales(productSales));
        System.out.println("Maximum sale:  " + calculator.MaxSale(productSales));
        System.out.println("Minimum sale:  " + calculator.MinSale(productSales));
        System.out.println("-----------------------------------");
    }
}
