package Gravitation_package;

import static Gravitation_package.BackEnd.*;
import static java.lang.Math.random;
import org.apache.commons.math3.linear.*;

public class Particule {

    //private ArrayRealVector VectPosition;
    //private RealVector VectChampGravitationnelSubi;
                // doit être déduit
    private double pX;
    private double pY;
    private double masse;
    private double densite;
    private double vX;
    private double vY;
    // private double aX;  inutile tant que pas d'accélération interne particule
    // private double aY;  ou que pas d'autres champs de force sont appliqués

    //private Vecteur2D champGravitationnel;

    public Particule() {
        this.masse = random() * 1000;
//        this.VectPosition=new ArrayRealVector(2);
//        this.VectPosition.setEntry(COORD_X, random() * LARGEUR_ESPACE);
//        this.VectPosition.setEntry(COORD_Y, random() * HAUTEUR_ESPACE);
        this.pX= random() * LARGEUR_ESPACE;
        this.pY= random() * HAUTEUR_ESPACE;
//        this.VectPosition.setEntry(COORD_Y, random() * HAUTEUR_ESPACE);
    }
    public Particule(double posX, double posY, double masse) {
        this.masse = masse;
//        this.VectPosition=new ArrayRealVector(2);
//        this.VectPosition.setEntry(COORD_X, posX);
//        this.VectPosition.setEntry(COORD_Y, posY);
        this.pX = posX;
        this.pY = posY;
    }

    public double getMasse() {
        return masse;
    }
    ArrayRealVector getVectPosition() {
        ArrayRealVector VecteurPosition = new ArrayRealVector(2);
        VecteurPosition.setEntry(COORD_X, this.pX);
        VecteurPosition.setEntry(COORD_Y, this.pY);  
        return VecteurPosition;
    }
    public void deplaceParticule(ArrayRealVector champDeForce) {
        //this.getVectPosition()
    }

}
