public class Test_Shape {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(10, 5);
        Shape s2 = new Circle(2);

        System.out.println("The size is "+s1.getArea());
        System.out.println("The size is "+s2.getArea());
    }

}

