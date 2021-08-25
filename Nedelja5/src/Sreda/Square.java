package Sreda;

public class Square extends Shape {
    private double a, b;
    /*Constructor*/

    public Square(String name, double a, double b) {
        super(name);
        if (a == b && a > 0){
            this.a = a;
            this.b = b;
        } else {
            System.out.println("Niste uneli ispravnu vrednost");
        }

    }
    /*Methods*/
    //TODO


    @Override
    public double circumference() {
        return 4 * a;
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
