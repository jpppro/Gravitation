/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gravitation_package;

import org.apache.commons.math3.linear.ArrayRealVector;

/**
 *
 * @author jpp
 */
public abstract class BackEnd {
    public static int LARGEUR_ESPACE=800;
    public static int HAUTEUR_ESPACE=400;
    public static int COORD_X = 0;
    public static int COORD_Y = 1;    
    public static double K;
    public static SystemeDeParticules espace;
    
    static void InitialiserParametres() {
        LARGEUR_ESPACE=1000;
        HAUTEUR_ESPACE=500;
        K=1;
    }
    
    static void Demarrer() {
        // TODO add your handling code here:
        espace = new SystemeDeParticules(LARGEUR_ESPACE,HAUTEUR_ESPACE);
        espace.Creer(3);
        final double x []={0,0};
        ArrayRealVector lieuTest = new ArrayRealVector(x);      
        ArrayRealVector forceDeGravitation = espace.CalculerChampGravitationSurLieu(lieuTest);
       
    }
   
}
