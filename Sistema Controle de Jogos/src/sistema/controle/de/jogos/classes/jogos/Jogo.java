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
public abstract class Jogo {
    protected String titulo;
    protected String plataforma;
    protected Float valor;
    protected int hype;
    
    Jogo(){
        
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    
    public void setPlataformaJogo(String plataforma, ArrayList<Plataforma> plataformasExistentes) throws PlataformaInexistente{
        boolean existe = false;
        for(Plataforma a : plataformasExistentes){
            existe = a.equals(a, plataforma);
        }
        if(existe == false){
            throw new PlataformaInexistente(plataforma + "inexistente\n");
        }
        else{
            this.plataforma = plataforma;
        }
    }
    
    public void setValor(Float valor) throws NumberFormatException{
        
        if (valor < 0.0){
            this.setValor(Float.parseFloat(JOptionPane.showInputDialog("Valor não pode ser negativo!\n Insira o valor: ")));
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
