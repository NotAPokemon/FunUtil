package dev.korgi.web.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
    X[] composition;
    public Function(X... composition){
        this.composition = composition;
        sort();
    }

    public Function(String func){
        func = func.replaceAll("\\s+", "");
        List<X> terms = new ArrayList<>();

        Pattern pattern = Pattern.compile("([+-]?\\d*\\.?\\d*)(x(?:\\^(\\d+))?)?");
        Matcher matcher = pattern.matcher(func);
        while (matcher.find()) {
            String coeffStr = matcher.group(1);  // Coefficient part
            String xPart = matcher.group(2);     // "x" part (null if constant)
            String degreeStr = matcher.group(3); // Exponent part (null if linear term)
            
            double coeff = (coeffStr.equals("") || coeffStr.equals("+")) ? 1 :
                           (coeffStr.equals("-")) ? -1 * Double.parseDouble(coeffStr) : Double.parseDouble(coeffStr);
            int degree = (xPart == null) ? 0 : (degreeStr == null ? 1 : Integer.parseInt(degreeStr));
            
            terms.add(new X(coeff, degree));
        }
        terms.remove(terms.size() - 1);

        this.composition = terms.toArray(new X[0]);
        sort();
    }

    public double evaluate(double value){
        double res = 0;
        for (int i = 0; i < composition.length; i++){
            res += composition[i].evaluate(value);
        }
        return res;
    }

    public void sort() {
        Arrays.sort(composition, Comparator.comparingDouble((X x) -> x.degree).reversed());
    }

    public Function getDerivative(){
        List<X> newComp = new ArrayList<X>();
        for (int i = 0; i < composition.length; i++){
            if (composition[i].coefficent * composition[i].degree == 0){
                continue;
            }
            newComp.add(new X(composition[i].coefficent * composition[i].degree, composition[i].degree - 1));
        }
        return new Function(newComp.toArray(new X[0]));
    }


    public Function getDerivative(int times){
        List<X> newComp = new ArrayList<X>();
        for (int i = 0; i < composition.length; i++){
            if (composition[i].coefficent * composition[i].degree == 0){
                continue;
            }
            newComp.add(new X(composition[i].coefficent * composition[i].degree, composition[i].degree - 1));
        }
        if (times == 1){
            return new Function(newComp.toArray(new X[0]));
        }
        return new Function(newComp.toArray(new X[0])).getDerivative(times - 1);
    }

    public boolean isConstant(){
        if (composition.length == 0){
            return true;
        }
        if (composition.length == 1){
            if (composition[0].coefficent == 0 || composition[0].degree == 0){
                return true;
            }
        }
        return false;
    }

    public Double getConstant(){
        if (composition.length == 0){
            return 0.0;
        }
        if (composition.length == 1){
            if (composition[0].coefficent == 0){
                return 0.0;
            } else if (composition[0].degree == 0){
                return composition[0].coefficent;
            }
        }

        return null;
    } 

    @Override
    public String toString() {
        String res = "";
        
        for (int i = 0 ; i < composition.length; i++){
            String sign = "";
            if (composition[i].coefficent > 0 && i != composition.length - 1){
                sign += "+ ";
            }
            res += composition[i].toString() + " " + sign;
            
        }

        if (res == ""){
            res += 0;
        }

        return res;
    }


}
