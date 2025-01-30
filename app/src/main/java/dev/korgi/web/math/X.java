package dev.korgi.web.math;

public class X {
    public double coefficent;
    public double degree;

    public X(double coefficent, double degree){
        this.coefficent = coefficent;
        this.degree = degree;
    }

    public double evaluate(double value){
        return coefficent * Math.pow(value, degree);
    }

    public boolean isConstant(){
        return coefficent == 0 || degree == 0;
    }

    public Double getConstant(){
        if (coefficent == 0){
            return 0.0;
        } else if (degree == 0){
            return coefficent;
        }
        return null;
    }

    @Override
    public String toString() {
        if (isConstant()){
            return getConstant().toString();
        }
        String v1 = "" + coefficent;
        String v2 = "^" + degree;

        if(coefficent % (int) coefficent == 0){
            v1 = "" + (int) coefficent;
        }
        if (degree % (int) degree == 0){
            v2 = "^" + (int) degree;
        }
        if (coefficent == 1){
            v1 = "";
        }
        if (degree == 1){
            v2 = "";
        }

        

        return v1 + "x" + v2;
    }
}
