package Gravitation_package;

import static Gravitation_package.BackEnd.*;
import static java.lang.Math.pow;
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
    ArrayRealVector getVectVitesse() {
        ArrayRealVector VecteurVitesse = new ArrayRealVector(2);
        VecteurVitesse.setEntry(COORD_X, this.vX);
        VecteurVitesse.setEntry(COORD_Y, this.vY);  
        return VecteurVitesse;
    }    
    public void deplacer(ArrayRealVector champDeForce, double deltaTemps) {
        //this.getVectPosition()
        // a=F/m
        // x=(at2)/2+v0t+x0
        // v=at+v0
        // ArrayRealVector VecteurAcceleration= champDeForce/masse;
        ArrayRealVector VecteurAcceleration= (ArrayRealVector)champDeForce.mapDivide(masse);
        ArrayRealVector at2sur2 = (ArrayRealVector)VecteurAcceleration.mapMultiply(pow(deltaTemps,2)/2);
        ArrayRealVector v0t = (ArrayRealVector)this.getVectVitesse().mapMultiply(deltaTemps);
                //this.getVectPosition()+.add(this.getVectVitesse)().add;
        ArrayRealVector VecteurPosition = this.getVectPosition().add(v0t).add(at2sur2);
        //= at2sur2 + ...
        ArrayRealVector VecteurVitesse=this.getVectVitesse().add(VecteurAcceleration.mapMultiply(deltaTemps));
        //        this.VectPosition.setEntry(COORD_X, posX);
//        this.VectPosition.setEntry(COORD_Y, posY);
        this.pX = VecteurPosition.getEntry(COORD_X);
        this.pY = VecteurPosition.getEntry(COORD_Y);
    }

}
