import java.util.*;
public class PointGrey extends Point {
    PointGrey(int a,int b,int c){
        px=a;
        py=b;
        greyscale=c;
    }
    // TODO: add a constructor for PointGrey


    public double getDistance(Point p) {
        // TODO: fill this function up
        double distence=Math.sqrt(Math.pow((this.px-p.px),2)+Math.pow((this.py-p.py),2));;
        return distence; // to be replaced
    }


    public int grayscaleDiff(Point p) {
        // TODO: fill this function up
         int i=this.greyscale-p.greyscale;
        return i; // to be replaced
    }

}
