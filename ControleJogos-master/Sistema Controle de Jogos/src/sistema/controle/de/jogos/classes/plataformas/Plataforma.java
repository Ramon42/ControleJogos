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
public abstract class Plataforma {
    protected String nomePlat;
    protected int codPlataforma;
    protected boolean VR;
    protected boolean iniciarVR;
    
    Plataforma(){
        this.VR = false;
        this.iniciarVR = false;
        
    }

    public void setPlataforma(String plataforma){
        this.nomePlat = plataforma;
    }
    public String getPlataforma(){
        return this.nomePlat;
    }
    public int getCodPlat(){
        return this.codPlataforma;
    }
    public boolean getVR(){
        return this.VR;
    }
    public void setVR(boolean VR){
        this.VR = VR;
    }
    
}
