/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.classes.usuario;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistema.controle.de.jogos.classes.plataformas.*;
import sistema.controle.de.jogos.classes.jogos.Acao;
import sistema.controle.de.jogos.classes.jogos.Jogo;
import sistema.controle.de.jogos.excecoes.PlataformaInexistente;

/**
 *
 * @author ramon
 */
public class Usuario {
    private String nomeUsuario;
    private String senha;
    private ArrayList<Jogo> biblioteca = new ArrayList();
    private ArrayList<Jogo> listaDesejo = new ArrayList();
    private ArrayList<Plataforma> plataformasUsuario = new ArrayList();
    
    public static <T> String nomeClasse(T t){
        return t.getClass().getName();
    }
    public void adicionarBiblioteca() throws PlataformaInexistente{
        int opcao;
        Jogo addJ;
        boolean valorValido = false;
        opcao = Integer.parseInt(JOptionPane.showInputDialog("Tema do jogo: \n"
                + "1- Ação"));
        
        switch(opcao){
            case 1:
                addJ = new Acao();
                break;
            default:
                addJ = new Acao();
        }
     
        while (true){
            try{
                if (valorValido == false){
                    addJ.setValor(Float.parseFloat(JOptionPane.showInputDialog("Valor jogo: ")));
                    valorValido = true;
                }
                addJ.setPlataformaJogo(JOptionPane.showInputDialog("Plataforma: "), this.plataformasUsuario);
                break;
            }
            catch(NumberFormatException n){
                valorValido = false;
                JOptionPane.showMessageDialog(null, "\nValor não pode ser diferente de Float");
            }
            catch(PlataformaInexistente p){
                JOptionPane.showMessageDialog(null, "\nUsuário não possui essa plataforma");
            }
        }
        this.biblioteca.add(addJ);
    }
    
    public String mostrarBiblioteca(){
        String aux = "";
        for(Jogo j : this.biblioteca){
            aux += "Plataforma: " + j.getPlataforma() + "\n";
            aux += "Valor: R$" + j.getValor() + "\n";
            aux += "\n\n";
        }
        return (aux);
    }
    
    public ArrayList getBiblioteca(){
        return this.biblioteca;
    }
    public String getUsuario(){
        return this.nomeUsuario;
    }
    public String getSenha(){
        return this.senha;
    }
    public ArrayList getPlataformas(){
        return this.plataformasUsuario;
    }
    public void addPlataforma(Plataforma nova){
        this.plataformasUsuario.add(nova);
    }
    
    public boolean equalsUsuario(Usuario a, String tentativa) {
        return a.getUsuario().equals(tentativa);
    }
    public boolean equalsSenha(Usuario a, String tentativa){
        return a.getSenha().equals(tentativa);
    }
    
    public void setUsuario(String usuario){
        this.nomeUsuario = usuario;
    }
    public void setSenha(String senha){
        if (senha.length() < 8){
            this.setSenha(JOptionPane.showInputDialog("Senha deve conter no minímo 8 caracteres: "));
        }
        else {
            this.senha = senha;
        }
    }
}
