/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author erdem
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException,Excep {
        // TODO code application logic here
        GITLanguage a=new GITLanguage();
     
        String s=args[0];
        
        a.menu(s);
      

       
       
    }
}
