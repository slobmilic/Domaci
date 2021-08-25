package Sreda;

public class Rectangle extends Shape {
    private double a, b;

    /*Constructor*/

    public Rectangle(String name, double a, double b) {
        super(name);
        if (a > 0 && b > 0){
            this.a = a;
            this.b = b;
        } else {
            System.out.println("Niste uneli validnu velicinu strane pravougaonika");
        }

    }
    /*Methods*/

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double circumference() {
        return a * 2 + b * 2;
    }

    //Shape: {name}
    //Circumference: {circumference()}
    //Area: {area()}
    //-----------------
    @Override
    public String toString() {
        return super.toString();
    }
}