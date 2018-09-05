/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.classes.plataformas;

/**
 *
 * @author ramon
 */
public abstract class Plataforma {
    protected String nomePlat;
    protected boolean emJogo;
    protected boolean possuiPlataforma;
    protected boolean VR;
    protected boolean iniciarVR;
    
    Plataforma(){
        this.emJogo = false;
        this.possuiPlataforma = false;
        this.VR = false;
        this.iniciarVR = false;
        
    }
    public static <T> String nomeClasse(T t){
        return t.getClass().getName();
    }
    
    public void iniciarJogo(){
        this.emJogo = true;
    }
    public void fecharJogo(){
        this.emJogo = false;
    }
    
    public void setPlataforma(String plataforma){
        this.nomePlat = plataforma;
    }
    public String getPlataforma(){
        return this.nomePlat;
    }

    public boolean equals(Plataforma a, String plataforma) {
        return nomeClasse(a).equals(plataforma);
    }
}
