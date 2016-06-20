/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpp.utilitaires.CalculsVectoriels;

import static java.lang.Math.*;
import org.apache.commons.math3.linear.*;

/**
 *
 * @author jpp
 */
public class Vecteur2D {
    private double x,y;
    
    public Vecteur2D() {
        this.x = 0;
        this.y = 0;        
    }
    public Vecteur2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        RealVector testVecteurReel;
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }   
    public Vecteur2D getDistance(Vecteur2D position) {
        this.x=this.getX()-position.getX();
        this.y=this.getY()-position.getY();
        return this;
    }
    public double getDistanceAbsolue(Vecteur2D position) {
        return (sqrt(pow(x,2)+pow(y,2)));
    }
}
