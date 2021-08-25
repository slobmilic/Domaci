package Sreda;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(String name, double a, double b, double c) {
        super(name);
        if((a+b)>c && (a+c)>b && (b+c)>a){
            this.a = a;
            this.b = b;
            this.c = c;
        }else {
            System.out.println("Niste uneli validne duzine strana za trougao");
        }

    }
    /*Methods*/

    @Override
    public double circumference() {
        return a + b + c;
    }

    @Override
    public double area() {
        double s = (a+b+c) / 2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}