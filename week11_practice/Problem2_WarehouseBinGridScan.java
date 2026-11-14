package week11_practice;

public class Problem2_WarehouseBinGridScan {

    public record WarehouseResult(long total, int maxRow, int maxCol) {
        @Override
        public String toString() {
            return "total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")";
        }
    }

    public static WarehouseResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new WarehouseResult(0, -1, -1);
        }

        int m = grid.length;
        int n = grid[0].length;

        long total = 0;
        int maxVal = -1;
        int maxRow = -1;
        int maxCol = -1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int current = grid[r][c];
                total += current;

                if (current > maxVal) {
                    maxVal = current;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        return new WarehouseResult(total, maxRow, maxCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        WarehouseResult result = warehouseSummary(grid);
        System.out.println(result);
    }
}
