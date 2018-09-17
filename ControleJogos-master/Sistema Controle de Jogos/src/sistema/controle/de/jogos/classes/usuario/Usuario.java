/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.classes.usuario;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Comparator;
import java.util.Collections;
import sistema.controle.de.jogos.classes.plataformas.*;
import sistema.controle.de.jogos.classes.jogos.Jogo;
import sistema.controle.de.jogos.excecoes.PlataformaInexistente;
import sistema.controle.de.jogos.interfaces.IVR;

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
        String auxStr;
        boolean valorValido = false, possuiVR = false;
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
                JOptionPane.showMessageDialog(null, "Por favor, insira apenas digitos válidos");
            }
            catch(PlataformaInexistente p){
                JOptionPane.showMessageDialog(null, "Usuário não possui essa plataforma");
            }
        }
        auxStr = JOptionPane.showInputDialog("Jogo é VR? (s/n)");
        if(auxStr.equals("s")){
            for (Plataforma x : this.plataformasUsuario){
                if(x instanceof IVR){
                    addJ.setJogoVR(true);
                    possuiVR = true;
                    break;
                }
            }
            if (!possuiVR)
                JOptionPane.showMessageDialog(null, "Plataforma não possui VR");

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
    public void excluir(String titulo){
            Jogo auxJogos = null;
            boolean remover = false;
        for (Jogo x : this.listaDesejo){
            if(x.getTitulo().compareToIgnoreCase(titulo) == 0){
                auxJogos = x;
                remover = true;
            }
        }
        if (remover){
            this.listaDesejo.remove(auxJogos);
            JOptionPane.showMessageDialog(null, "Jogo excluido com sucesso!");
        }
    }
    
    public void organizar(int codOrganizar){ //cod 1= organizar por titulo, 2= tema, 3= valor
        Collections.sort(this.biblioteca, new Comparator() {
            @Override
            public int compare(Object t, Object t1) {
                Jogo c1 = (Jogo) t;  
		Jogo c2 = (Jogo) t1;  
                switch (codOrganizar) {
                    case 1:
                        return c1.getTitulo().compareToIgnoreCase(c2.getTitulo());
                    case 2:
                        return c1.getTema().compareToIgnoreCase(c2.getTema());
                    case 3:
                        return c1.getValor().compareTo(c2.getValor());
                    default:
                        return 0;
                }
            }
        }) ;
        }

    public Plataforma getPlataformasValidasUsuario(int opcPlat) {
        for(Plataforma a : this.plataformasUsuario){
            if (a.getCodPlat() == opcPlat){
                return a;
            }
        }
        return null;
    }
}
