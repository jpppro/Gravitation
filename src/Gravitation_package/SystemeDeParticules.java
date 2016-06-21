/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gravitation_package;

import jpp.utilitaires.CalculsVectoriels.Vecteur2D;
import static Gravitation_package.Gravitation02_ClassicWindowed.*;
import static java.lang.Math.*;
import java.util.*;
import org.apache.commons.math3.linear.*;

public class SystemeDeParticules {
    private int espaceX;
    private int espaceY;
    private int nombre_de_particules;
    private ArrayList LesParticulesDuSysteme;
    private double distanceX;
    private double distanceY;
    private double masse;

    public SystemeDeParticules(int largeur, int hauteur) {
        this.espaceX = largeur;
        this.espaceY = hauteur;
        this.LesParticulesDuSysteme = new ArrayList();
    }      
    public SystemeDeParticules(int largeur, int hauteur, int nb_particules) {
        this(largeur, hauteur);     
        this.LesParticulesDuSysteme = new ArrayList();
        this.Creer(nb_particules);
    }          
    final public void Creer(int nb_particules) {
        /** Crée le système de particules avec un nombre initial de particules 
        * y placées au hasard **/          
        Particule uneDesParticules;
        this.nombre_de_particules=nb_particules;
        if (nb_particules>1) {
            for (int indice_particule=1;indice_particule<=nb_particules;indice_particule++) {
                uneDesParticules=new Particule();
                this.getLesParticulesDuSysteme().add(uneDesParticules);
            }
        }
    }
    public void AjouterUneParticule() {
        // à implémenter
    }
    
    public ArrayRealVector CalculerChampGravitationSurLieu(ArrayRealVector VecteurLieu) { 
        
        /** Calcule le champ de (force de) gravitation à un endroit donné
            parcourir toutes les particules
                déterminer sa distance au lieu de calcul
                calculer sa force d'attraction sur le lieu (vecteur)
            retourner en vecteur la somme des vecteurs force **/       
        
        ArrayRealVector force = new ArrayRealVector(2);
        
        for (int indice=0;indice<this.getLesParticulesDuSysteme().size(); indice++) {
            Particule uneParticule=(Particule)this.getLesParticulesDuSysteme().get(indice);
            ArrayRealVector vPos = new ArrayRealVector(2);
            vPos=uneParticule.getVectPosition();
            double laDistanceAbsolue;
            laDistanceAbsolue=VecteurLieu.getDistance(vPos);

            if (laDistanceAbsolue != 0) {
//                force.setEntry(COORD_X,K*masse/pow(laDistanceAbsolue,2)*distanceX/laDistanceAbsolue);
//                force.setEntry(COORD_Y,K*masse/pow(laDistanceAbsolue,2)*distanceY/laDistanceAbsolue);
                force= (ArrayRealVector) vPos.mapDivide(laDistanceAbsolue);
            //else
            //    force = new Vecteur2D(0,0);
            }
        }
        return force;
    }
    public SystemeDeParticules getSystemeDeParticules() {
        return this;
    }

    /**
     * @return the nombre_de_particules
     */
    public int getNombre_de_particules() {
        return nombre_de_particules;
    }

    /**
     * @return the LesParticulesDuSysteme
     */
    public ArrayList getLesParticulesDuSysteme() {
        return LesParticulesDuSysteme;
    }
    public double[] getPositionParticule(int indice) {
        double [] Position;
        Particule uneParticule = (Particule)this.LesParticulesDuSysteme.get(indice);
        return uneParticule.getVectPosition().toArray();
    }
    
    public ArrayRealVector getVecteurPositionParticule(int indice) {
        ArrayRealVector vecteurPosition = new ArrayRealVector(2);
        Particule uneParticule = (Particule)this.LesParticulesDuSysteme.get(indice);
        vecteurPosition=uneParticule.getVectPosition();
        return vecteurPosition;
    }
}