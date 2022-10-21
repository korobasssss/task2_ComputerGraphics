package cs.vsu.ruKorobeynikova_A_V.transformations;

import java.util.List;

public class Rotate {
    double alpha;

    public Rotate(double alpha) {
        this.alpha = -(alpha * Math.PI / 180);
    }

    public List<int[]> rotateFigure(List<int[]> points) {
        double[][] matrixRotate = {
                {Math.cos(alpha), Math.sin(alpha), 0},
                {-Math.sin(alpha), Math.cos(alpha), 0},
                {0, 0, 1},
        };

        for (int row = 1; row < points.size(); row++) {
            int[] point = new int[points.get(0).length];
            for (int col = 0; col < points.get(0).length; col++) {
                point[col] = multiplication(points, matrixRotate, row, col);
            }
            points.set(row, point);
        }
        return points;
    }

    private int multiplication(List<int[]> arr1, double[][] arr2, int row, int col) {
        double cell = 0;
        for (int i = 0; i < arr2.length; i++) {
            cell += (arr1.get(row)[i] - arr1.get(0)[i]) * arr2[i][col];
        }
        return (int) Math.round(cell + arr1.get(0)[col]);
    }


}
