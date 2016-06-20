///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jpp.utilitaires.CalculsVectoriels;
//
//import Gravitation_package.Particule;
//import jpp.utilitaires.CalculsVectoriels.Vecteur2D;
//import static Gravitation_package.ApplicationGravitation.K;
//import static java.lang.Math.*;
//import java.util.*;
//public class SystemeDeParticulesOLD {
//    private int espaceX;
//    private int espaceY;
//    private int nombre_de_particules;
//    private ArrayList systemeP;
//    private double distanceX;
//    private double distanceY;
//    private double masse;
//
//    public SystemeDeParticulesOLD(int largeur, int hauteur) {
//        this.espaceX = largeur;
//        this.espaceY = hauteur;
//        this.systemeP = new ArrayList();
//    }          
//    public void Creer(int nb_particules) {
//        /** Crée le système de particules avec un nombre initial de particules 
//        * y placées au hasard **/            
//        this.nombre_de_particules=nb_particules;
//        if (nb_particules>1) {
//            for (int indice_particule=1;indice_particule<=nb_particules;indice_particule++) {
//                this.systemeP.add(new Particule());
//            }
//        }
//    }
//    public void AjouterUneParticule() {
//        // à implémenter
//    }
//    public Vecteur2D CalculerChampGravitationSurLieu(Vecteur2D leLieu) { 
//        /** Calcule le champ de (force de) gravitation à un endroit donné **/
//
//        Vecteur2D force = null;
//        Vecteur2D champ = new Vecteur2D();
//        // parcourir toutes les particules
//        //      déterminer sa distance au lieu de calcul
//        //      calculer sa force d'attraction sur le lieu (vecteur)
//        // retourner en vecteur la somme des vecteurs force
//        for (int indice=0;indice<this.systemeP.size(); indice++) {
//              Particule uneParticule=(Particule)this.systemeP.get(indice);
//              Vecteur2D distance = new Vecteur2D();
//              double laDistanceAbsolue;
//              //(uneParticule.getLieu());
//              distance=leLieu.getDistance(uneParticule.getLieu());
//              distanceX = distance.getX();
//              distanceY = distance.getY();
//              masse=uneParticule.getMasse();
//              laDistanceAbsolue=leLieu.getDistanceAbsolue(uneParticule.getLieu());
//              if (laDistanceAbsolue != 0)
//                  force = new Vecteur2D (K*masse/pow(laDistanceAbsolue,2)*distanceX/laDistanceAbsolue, K*masse/pow(laDistanceAbsolue,2)*distanceY/laDistanceAbsolue);
//              else
//                  force = new Vecteur2D(0,0);
//              
//       }
//        
//                        //particuleDistante=(Particule)this.systemeP.get(2);
//
//                return champ;
//    }
//}