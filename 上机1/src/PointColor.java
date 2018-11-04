import java.util.*;
public class PointColor extends Point{
   protected int R;
   protected int G;
   protected int B;
   PointColor(int a,int b,int c,int d,int e) {
       px = a;
       py = b;
       R = c;
       G = d;
       B = e;
       this.greyscale=(R+G+B)/3;
   }
    //int greyscale=(R+G+B)/3;
    public double getDistance(Point p) {
        // TODO: fill this function up
        double distence=Math.sqrt(Math.pow((this.px-p.px),2)+Math.pow((this.py-p.py),2));
        return distence; // to be replaced
    }

    public int grayscaleDiff(Point p) {
        // TODO: fill this function up
        int i=Math.abs((R+G+B)/3-p.greyscale);
        return i; // to be replaced
    }
}
