/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraphiques;

import static Gravitation_package.BackEnd.HAUTEUR_ESPACE;
import static Gravitation_package.BackEnd.LARGEUR_ESPACE;
import static Gravitation_package.BackEnd.espace;
import Gravitation_package.Particule;
import Gravitation_package.SystemeDeParticules;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.apache.commons.math3.linear.ArrayRealVector;

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

        // TODO add your handling code here:
        espace = new SystemeDeParticules(LARGEUR_ESPACE, HAUTEUR_ESPACE);
        espace.Creer(3);
        int compteur = 0;

        while (true) {
            BoucleTemporelle(1000);
            compteur++;
            if (compteur % 10000 == 0) {
                System.out.println(compteur);
            }
        }
    }

    static void BoucleTemporelle(double temps_ecoule) {
        /**
         * BoucleTemporelle est exécutée dès que possible Pour chaque particule
         * du système, elle: - détermine sa position - calcule le champ de force
         * qui lui est appliqué - détermine les positions, vitesses et
         * accélérations en fonction du champ - déplace la particule en
         * conséquence
        *
         */
        int max_nb_particules = espace.getLesParticulesDuSysteme().size();
        for (int indice_particule = 0; indice_particule < max_nb_particules; indice_particule++) {
            Particule laParticule = new Particule();
            laParticule = espace.getParticule(indice_particule);
//            ArrayRealVector leVecteurPosition = espace.getVecteurPositionParticule(indice_particule);
            ArrayRealVector leVecteurPosition = laParticule.getVectPosition();
            ArrayRealVector leVecteurForce = espace.CalculerChampGravitationSurLieu(leVecteurPosition);
            laParticule.deplacer(leVecteurForce, temps_ecoule);

        }
    }
}
