/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.classes.plataformas;

import sistema.controle.de.jogos.interfaces.IVR;

/**
 *
 * @author ramon
 */
public class PS4 extends Plataforma implements IVR{
    
    public PS4(){
        this.nomePlat = "PlayStation 4";
        this.codPlataforma = 2;
    }

    @Override
    public void adquirirVR() {
        this.VR = true;
    }

}