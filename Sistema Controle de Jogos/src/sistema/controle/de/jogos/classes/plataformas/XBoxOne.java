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
public class XBoxOne extends Plataforma implements IVR{

    
    @Override
    public void adquirirVR() {
        this.VR = true;
    }
    @Override
    public void iniciarVR() {
        if(this.VR)
            this.iniciarVR = true;
    }

    @Override
    public void fecharVR() {
        if(this.VR)
            this.iniciarVR = false;
    }

    
}
