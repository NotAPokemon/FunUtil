package dev.korgi.web.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Polynomial {
    X[] composition;
    public Polynomial(X... composition){
        this.composition = composition;
        sort();
    }


    public Polynomial(String text){
        this.composition = parseText(text)
        sort();
    }

    public X[] parseText(String text){
        List<String> tokens = new ArrayList();
        List<X> restult = new ArrayList();
        String current = "";
        for (int i = 0; i < text.length){
            //implement later
        }

        return restult.toArray(new X[0]);
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

    public Polynomial getDerivative(){
        List<X> newComp = new ArrayList<X>();
        for (int i = 0; i < composition.length; i++){
            if (composition[i].coefficent * composition[i].degree == 0){
                continue;
            }
            newComp.add(new X(composition[i].coefficent * composition[i].degree, composition[i].degree - 1));
        }
        return new Polynomial(newComp.toArray(new X[0]));
    }


    public Polynomial getDerivative(int times){
        List<X> newComp = new ArrayList<X>();
        for (int i = 0; i < composition.length; i++){
            if (composition[i].coefficent * composition[i].degree == 0){
                continue;
            }
            newComp.add(new X(composition[i].coefficent * composition[i].degree, composition[i].degree - 1));
        }
        if (times == 1){
            return new Polynomial(newComp.toArray(new X[0]));
        }
        return new Polynomial(newComp.toArray(new X[0])).getDerivative(times - 1);
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
