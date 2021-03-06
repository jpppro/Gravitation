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
        int compteur = 0;
  
        while (true) {
            BoucleTemporelle(1000);
            compteur ++;
            if (compteur % 10000 == 0) System.out.println(compteur);
        }
    }
    static void BoucleTemporelle(double temps_ecoule) {
        /** BoucleTemporelle est exécutée dès que possible
         *      Pour chaque particule du système, elle:
         *          - détermine sa position
         *          - calcule le champ de force qui lui est appliqué
         *          - détermine les positions, vitesses et accélérations en fonction du champ
         *          - déplace la particule en conséquence
        **/
        int max_nb_particules=espace.getLesParticulesDuSysteme().size();
        for (int indice_particule=0;indice_particule<max_nb_particules;indice_particule++) {
            Particule laParticule=new Particule();
            laParticule = espace.getParticule(indice_particule);
//            ArrayRealVector leVecteurPosition = espace.getVecteurPositionParticule(indice_particule);
            ArrayRealVector leVecteurPosition = laParticule.getVectPosition();
            ArrayRealVector leVecteurForce = espace.CalculerChampGravitationSurLieu(leVecteurPosition);
            laParticule.deplacer(leVecteurForce, temps_ecoule);

        }
       
    }    
   
}
