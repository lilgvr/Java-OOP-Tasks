import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class My extends java.awt.geom.Line2D{



    protected double x1,y1,x2,y2;

    public double getX1() {
        return 0;
    }

    public double getY1() {
        return 0;
    }

    public Point2D getP1() {
        return null;
    }

    public double getX2() {
        return 0;
    }

    public double getY2() {
        return 0;
    }

    public Point2D getP2() {
        return null;
    }

    public void setLine(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle2D getBounds2D() {
        return null;
    }
}
