/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

/**
 *
 * @author erdem
 */
public class Float {
    private String label;
    private double number;
    
    public Float(String s,double i){
        label=s;
        number=i;
    }
    
    
    public void setN(double m){
        number=m;
    }
    public void setL(String l){
        label=l;
    }
    public String getL(){
        return label;
    }
    public double getN(){
        return number;
    }
}
