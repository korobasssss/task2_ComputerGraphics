package cs.vsu.ruKorobeynikova_A_V.transformations;

import java.util.List;

public class Move {
    double x; double y;

    public Move(double x, double y) {
        this.x = x;
        this.y = -y;
    }

    public List<int[]> moveFigure(List<int[]> points) {
        double[][] matrixStretch = new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {x, y, 1}
        };

        for (int row = 0; row < points.size(); row++) {
            int[] point = new int[points.get(0).length];
            for (int col = 0; col < points.get(0).length; col++) {
                point[col] = multiplication(points, matrixStretch, row, col);
            }
            points.set(row, point);
        }
        return points;
    }

    private int multiplication(List<int[]> arr1, double[][] arr2, int row, int col) {
        double cell = 0;
        for (int i = 0; i < arr2.length; i++) {
            cell += arr1.get(row)[i] * arr2[i][col];
        }
        return (int) Math.round(cell);
    }
}
