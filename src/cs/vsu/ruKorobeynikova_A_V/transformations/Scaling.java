package cs.vsu.ruKorobeynikova_A_V.transformations;

import java.util.List;

public class Scaling {
    double x; double y;

    public Scaling(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public List<int[]> scalingFigure(List<int[]> points) {
        double[][] matrixScale = new double[][]{
                {x, 0, 0},
                {0, y, 0},
                {0, 0, 1}
        };

        for (int row = 1; row < points.size(); row++) {
            int[] point = new int[points.get(0).length];
            for (int col = 0; col < points.get(0).length; col++) {
                point[col] = multiplication(points, matrixScale, row, col);
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
        return (int)Math.round(cell + arr1.get(0)[col]) ;
    }
}
