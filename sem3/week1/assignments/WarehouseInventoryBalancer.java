/**
 * Program Name  : WarehouseInventoryBalancer
 * Class Name    : WarehouseInventoryBalancer
 * Description   : Week 1 Assignment - Problem 4: The Warehouse Inventory Balancer.
 *                 Computes stock quantities for Section A and B, checks balance,
 *                 and identifies highest-quantity item.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            throw new IllegalArgumentException("Section arrays cannot be null");
        }

        int totalA = 0;
        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemNumber = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemNumber = i + 1; // 1-valued item number
            }
        }

        int totalB = 0;
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemNumber = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestItemNumber);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       WAREHOUSE INVENTORY BALANCER           ");
        System.out.println("==================================================\n");

        int[] secA2 = {20, 15, 30};
        int[] secB1 = {25, 10, 30};
        System.out.println("Case 1 (Balanced):");
        analyzeInventory(secA2, secB1);

        System.out.println("--------------------------------------------------");

        int[] secA3 = {30, 40, 50};
        int[] secB3 = {25, 30, 40};
        System.out.println("Case 2 (Not Balanced):");
        analyzeInventory(secA3, secB3);
    }
}