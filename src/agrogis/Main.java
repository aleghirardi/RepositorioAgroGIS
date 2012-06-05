/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agrogis;

import Ventanas_Transporte.frmPrincipal;
import de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import Hibernate.HibernateUtil;



public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       HibernateUtil.inicializar();
        
        try {
            UIManager.setLookAndFeel(new SyntheticaGreenDreamLookAndFeel());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
                
            public void run() {
                new frmPrincipal().setVisible(true); {

             };
            }
        });
    }

}
