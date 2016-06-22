/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraphiques;

import Gravitation_package.BackEnd;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author jpp
 */
public class IHM_designController implements Initializable {

    @FXML
    private Button btnDemarrer;
    @FXML
    private AnchorPane AffichageDesParticules;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Demarre(ActionEvent event) {
        System.out.println("test");
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
                AffichageDesParticules.getChildren().add(cercle1);      
            }        
    }
    
}
