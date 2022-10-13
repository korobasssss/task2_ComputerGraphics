package cs.vsu.ruKorobeynikova_A_V.figures;

public class Triangle {
    double x1; double y1;
    double x2; double y2;
    double x3; double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }


    public double getX1() {
        return x1;
    }
    public double getX2() {
        return x2;
    }
    public double getX3() {
        return x3;
    }
    public double getY1() {
        return y1;
    }
    public double getY2() {
        return y2;
    }
    public double getY3() {
        return y3;
    }
}
