/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.classes.usuario;

import java.text.DecimalFormat;
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
    private DecimalFormat df = new DecimalFormat("0.00");
    
    public static <T> String nomeClasse(T t){
        return t.getClass().getName();
    }
    public void adicionarBiblioteca(int opcLista) throws PlataformaInexistente{
        Jogo addJ = new Jogo();
        boolean valorValido = false;
        addJ.setTitulo(JOptionPane.showInputDialog("Titulo do jogo: "));
        addJ.setTema(JOptionPane.showInputDialog("Tema do jogo: "));
     
        while (true){
            try{
                if (valorValido == false){
                    addJ.setValor(Float.parseFloat(JOptionPane.showInputDialog("Valor jogo: ")));
                    valorValido = true;
                }
                int opcPlat = Integer.parseInt(JOptionPane.showInputDialog("Plataforma: \n"
                + "1- XBox One\n"
                + "2- PlayStation 4\n"
                + "3- Nintendo Switch\n"
                + "4- PC\n"));
                addJ.setPlataformaJogo(opcPlat, this.plataformasUsuario);
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
        if (opcLista == 1)
            this.biblioteca.add(addJ);
        else if (opcLista == 2)
            this.listaDesejo.add(addJ);
    }
    
    public String mostrarBiblioteca(int opcLista){
        String aux = "";
        ArrayList<Jogo> auxJogos = null;
        if(opcLista == 1){
            auxJogos = this.biblioteca;
        }
        else if(opcLista == 2){
            auxJogos = this.listaDesejo;
        }
        for(Jogo j : auxJogos){
            aux += "Titulo: " + j.getTitulo() + "\n";
            aux += "Tema: " + j.getTema() + "\n";
            aux += "Plataforma: " + j.getPlataforma() + "\n";
            aux += "Valor: R$" + this.df.format(j.getValor()) + "\n";
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
    
    public void novoDesejo(){
        Jogo addJ = new Jogo();
        addJ.setTitulo(JOptionPane.showInputDialog("Titulo do jogo: "));
        addJ.setTema(JOptionPane.showInputDialog("Tema do jogo: "));
        
    }
}
