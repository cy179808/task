import java.util.*;
public class Rectangle extends Shape{
    protected int width;
    protected int height;

    public Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public double getArea() {
        double i=this.width*this.height;
        return i;
    }

}
