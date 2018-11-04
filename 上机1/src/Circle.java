import java.util.*;
public class Circle extends Shape{
    protected int radius;

    public Circle(int i){
        this.radius=i;
    }

    public double getArea() {
        double i=this.radius*3.14;
        return i;
    }
}
