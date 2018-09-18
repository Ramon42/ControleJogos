/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.classes.jogos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistema.controle.de.jogos.classes.plataformas.*;
import sistema.controle.de.jogos.excecoes.*;
/**
 *
 * @author ramon
 */
public class Jogo {
    private String titulo;
    private String plataforma;
    private String tema;
    private Float valor;
    private boolean jogoVR;
    private int codExclusivo; //0 = não é exclusivo
    
    public Jogo(){
        this.titulo = "default";
        this.jogoVR = false;
        this.codExclusivo = 0;
    }
    
    public void setCodExclusivo(int cod){
        this.codExclusivo = cod;
    }
    public int getCodExclusivo(){
        return this.codExclusivo;
    }
    public void setJogoVR(boolean jogoVR){
        this.jogoVR = jogoVR;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    
    public void setTema(String tema){
        this.tema = tema;
    }
    public String getTema(){
        return this.tema;
    }
    public Plataforma getPlataformasValidas(int codPlat, ArrayList<Plataforma> plataformasExistentes){
        for(Plataforma a : plataformasExistentes){
            if (a.getCodPlat() == codPlat){
                return a;
            }
        }
        return null;
    }
    public void setPlataformaJogo(int codPlat, ArrayList<Plataforma> plataformasExistentes) throws PlataformaInexistente{
        Plataforma aux = this.getPlataformasValidas(codPlat, plataformasExistentes);
        if (aux != null)
            this.plataforma = aux.getPlataforma();
        
        else
            throw new PlataformaInexistente(plataforma + "inexistente\n");

        /*
        boolean existe = false;
        for(Plataforma a : plataformasExistentes){
            if (a.getCodPlat() == codPlat){
                this.plataforma = a.getPlataforma();
                existe = true;
            }
        }
        if(existe == false){
            throw new PlataformaInexistente(plataforma + "inexistente\n");
        }
*/
    }
    
    public void setValor(Float valor) throws NumberFormatException{
        
        if (valor < 0.0){
            this.setValor(Float.parseFloat(JOptionPane.showInputDialog("Valor não pode ser negativo!\n Insira o valor: ")));
            throw new NumberFormatException();
        }
        else{
            this.valor = valor;
        }
        
    }
    public String getPlataforma(){
        return this.plataforma;
    }
    public Float getValor(){
        return this.valor;
    }
    
}
