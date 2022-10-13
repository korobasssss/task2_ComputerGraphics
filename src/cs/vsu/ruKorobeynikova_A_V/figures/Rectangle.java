package cs.vsu.ruKorobeynikova_A_V.figures;

public class Rectangle {
    int x1; int y1;
    int x2; int y2;
    int x3; int y3;
    int x4; int y4;

    public Rectangle(int[][] points){
        this.x1 = points[0][0];
        this.x2 = points[0][1];
        this.x3 = points[0][2];
        this.x4 = points[0][3];
        this.y1 = points[1][0];
        this.y2 = points[1][1];
        this.y3 = points[1][2];
        this.y4 = points[1][3];
    }


    public int getX1() {
        return x1;
    }
    public int getX2() {
        return x2;
    }
    public int getX3() {
        return x3;
    }
    public int getX4() {
        return x4;
    }
    public int getY1() {
        return y1;
    }
    public int getY2() {
        return y2;
    }
    public int getY3() {
        return y3;
    }
    public int getY4() {
        return y4;
    }
}
