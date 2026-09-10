/**
 * Program Name  : ProductInventoryCsvParser
 * Class Name    : ProductInventoryCsvParser
 * Description   : Week 2 Assignment - Problem 3: Product Inventory CSV Parser.
 *                 Parses csv lines ("<ProductName>,<SKU>,<Quantity>"),
 *                 validates fields, and prints formatted records.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class ProductInventoryCsvParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Product: %s | SKU: %s | Qty: %s\n", productName, sku, quantity);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       PRODUCT INVENTORY CSV PARSER             ");
        System.out.println("==================================================\n");

        String[] testLines = {
            "Wireless Mouse,WM-2201,150",
            "Wireless Mouse,150",
            "Gaming Keyboard,GK-9001,50",
            "Laptop Stand,LS-01,20,ExtraField",
            ",150,WM-2201",
            ""
        };

        for (String line : testLines) {
            System.out.println("Input: \"" + line + "\"");
            System.out.print("Output: ");
            parseInventoryRecord(line);
            System.out.println("------------------------------------------------");
        }
    }
}