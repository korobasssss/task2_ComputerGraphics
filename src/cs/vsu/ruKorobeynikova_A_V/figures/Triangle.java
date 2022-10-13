package cs.vsu.ruKorobeynikova_A_V.figures;

public class Triangle {
    int x1; int y1;
    int x2; int y2;
    int x3; int y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
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
    public int getY1() {
        return y1;
    }
    public int getY2() {
        return y2;
    }
    public int getY3() {
        return y3;
    }
}
