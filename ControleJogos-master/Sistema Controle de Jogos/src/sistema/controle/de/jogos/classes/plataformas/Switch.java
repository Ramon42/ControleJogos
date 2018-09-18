/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.classes.plataformas;

import javax.swing.JOptionPane;

/**
 *
 * @author ramon
 */
public class Switch extends Plataforma{
    public Switch(){
        this.nomePlat = "Switch";
        this.codPlataforma = 3;
    }
    public void setVR(boolean VR){
        JOptionPane.showMessageDialog(null, "Plataforma não possui VR!");
    }
}
