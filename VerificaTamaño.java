package proyecto;


import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author velasam
 */
public class VerificaTamaño extends InputVerifier {

    @Override
    public boolean verify(JComponent jc) {
        String text = ((JTextField) jc).getText();
        try {
            Integer value = Integer.parseInt(text);
            return value >= 6 && value <= 1000;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    
}
