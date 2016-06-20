/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests_JPP;

import java.util.Arrays;
import org.apache.commons.math3.linear.ArrayRealVector;

/**
 *
 * @author pezzut01
 */
public class Test3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double [] a = new double[2];
        double [] b = {1.0,2.0};
        a[0]=0;
        a[1]=1;
        
        ArrayRealVector vecteur ;
        vecteur = new ArrayRealVector(b);
        
        //b[]=a[]+a[];
        //java.util.Arrays.
        System.out.println(Arrays.toString(b));
    }
    
}
