/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gravitation_package;

import static Gravitation_package.BackEnd.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 *
 * @author jpp
 */
public class Gravitation03_JavaFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root,LARGEUR_ESPACE,HAUTEUR_ESPACE);
        stage.setTitle("Titre de la fenetre");
        stage.maxWidthProperty();
        stage.setScene(scene);

      
        //BackEnd lApplication = new BackEnd();
        BackEnd.InitialiserParametres();
        BackEnd.Demarrer();

        SystemeDeParticules TestSysPart = BackEnd.espace; 
        
        
        //Afficher les particules du système
        stage.show();
        int nombre_de_particules = BackEnd.espace.getNombre_de_particules();
            for (int nb_part=0;nb_part<nombre_de_particules;nb_part++) {
                double p[]=BackEnd.espace.getPositionParticule(nb_part);
                double a=p[0];
                double b=p[1];
                Circle cercle1=new Circle();
                cercle1.setCenterX(a);
                cercle1.setCenterY(b);
                cercle1.setRadius(2);
                
                //cercle1.setStroke(Color.BLACK);
                System.out.println("Cercle " + nb_part + " -x:" + a + "-y:" + b);
                root.getChildren().add(cercle1);      
                stage.show();
            }
      
        
        Line line1 = new Line();
        line1.setStartX(0);
        line1.setStartY(0);
        line1.setEndX(LARGEUR_ESPACE);
        line1.setEndY(HAUTEUR_ESPACE);
        line1.setStroke(Color.BLACK);
        root.getChildren().add(line1);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
