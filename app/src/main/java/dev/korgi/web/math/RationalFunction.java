package dev.korgi.web.math;

public class RationalFunction {
    Function numerator;
    Function denominator;
    Function additive = null;

    public RationalFunction(Function numerator, Function denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public RationalFunction(Function numerator, Function denominator, Function additive){
        this.numerator = numerator;
        this.denominator = denominator;
        this.additive = additive;
    }


    public RationalFunction(Function numerator, Function denominator, double additive){
        this.numerator = numerator;
        this.denominator = denominator;
        this.additive = new Function(new X(additive,0));
    }

    public double evaluate(double v){
        double d = denominator.evaluate(v);
        double n = numerator.evaluate(v);
        double a = additive == null ? 0 : additive.evaluate(v);
        return d / n + a;
    }


    @Override
    public String toString() {
        return numerator.toString() + "\n--------------" + denominator.toString();
    }
    
}
