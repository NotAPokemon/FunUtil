package dev.korgi.web.math;

public class MustangMath {
    public static final double π = Math.PI;

    public static void main(String[] args) {
        System.out.println(new Polynomial(new X(4,4), new X(3,3), new X(2, 2), new X(1,1), new X(11,0)).getDerivative(4));
    }
    
}
