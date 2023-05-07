/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

/**
 *
 * @author erdem
 */
public class Int {
    private String label;
    private int num;
    
    Int(){
        
    }
    
    Int(String s,int i){
        label=s;
        num=i;
    }
    
    
    public void setN(int n){
        num=n;
    }
    public void setL(String m){
            label=m;
    }
    public String getL(){
        return label;
    }
    public int getN(){
        return num;
    }
}
