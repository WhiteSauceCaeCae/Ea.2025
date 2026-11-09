package app;

import java.awt.FlowLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ProductSalesApp extends JFrame {

    private static final String OUTPUT_FILE = "data.txt";
    private static final String STARS = "**********************";

    private final IProductSales productSales = new ProductSales();

    private final JButton loadButton = new JButton("Load Product Data");
    private final JButton saveButton = new JButton("Save Product Data");
    private final JTextArea reportArea = new JTextArea(6, 20);
    private final JLabel yearsLabel = new JLabel();

    public ProductSalesApp() {
        super("Product Sales Application");
        buildMenu();
        buildForm();

        // Both buttons and the matching menu items share the same logic
        loadButton.addActionListener(e -> loadProductData());
        saveButton.addActionListener(e -> saveProductData());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void buildForm() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        loadButton.setPreferredSize(new java.awt.Dimension(250, 28));
        saveButton.setPreferredSize(new java.awt.Dimension(250, 28));

        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(250, 110));

        // Read-only display of the years processed
        yearsLabel.setPreferredSize(new java.awt.Dimension(250, 24));
        yearsLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

        add(loadButton);
        add(saveButton);
        add(scrollPane);
        add(yearsLabel);
        setSize(300, 330);
    }

    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");
        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductData());
        clearItem.addActionListener(e -> clearData());
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    // Builds the report text from the calculated values
    private String buildReport() {
        return "Total Sales: " + productSales.GetTotalSales() + "\n"
                + "Average Sales: " + Math.round(productSales.GetAverageSales()) + "\n"
                + "Sales over limit: " + productSales.GetSalesOverLimit() + "\n"
                + "Sales under limit: " + productSales.GetSalesUnderLimit();
    }

    private void loadProductData() {
        reportArea.setText(buildReport());
        yearsLabel.setText("Years Processed: " + productSales.GetProductsProcessed());
    }

    private void saveProductData() {
        if (reportArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Load the product data before saving.");
            return;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            writer.println("DATA LOG");
            writer.println(STARS);
            writer.println(reportArea.getText().replace("\n", System.lineSeparator()));
            writer.println(STARS);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save the file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearData() {
        reportArea.setText("");
        yearsLabel.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesApp().setVisible(true));
    }
}
