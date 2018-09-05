/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.classes;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistema.controle.de.jogos.classes.plataformas.*;
import sistema.controle.de.jogos.classes.jogos.Acao;
import sistema.controle.de.jogos.classes.jogos.Jogo;
import sistema.controle.de.jogos.classes.usuario.Usuario;
import sistema.controle.de.jogos.excecoes.*;

/**
 *
 * @author ramon
 */
public class ControleJogos {
    private ArrayList<Usuario> usuarios = new ArrayList();
    private Usuario usuarioAtual;
    
    private Plataforma configPlataforma(){
        Plataforma plataforma = null;
        int opcPlat = Integer.parseInt(JOptionPane.showInputDialog("Plataforma Inicial: \n"
                + "1- XBox One\n"
                + "2- PlayStation 4\n"
                + "3- Nintendo Switch\n"
                + "4- PC\n"));
        switch(opcPlat){
            case 1:
                plataforma = new XBoxOne();
                break;
            case 3:
                plataforma = new Switch();
                break;
        }
        return (plataforma);
    }
    
    public void addNovoUsuario(){
        String login, senha, plataforma;
        this.usuarioAtual.addPlataforma(configPlataforma());
        login = JOptionPane.showInputDialog("Login novo usuário: ");
        senha = JOptionPane.showInputDialog("Senha novo usuário: ");
        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsuario(login);
        novoUsuario.setSenha(senha);
        this.usuarios.add(novoUsuario);
        this.usuarioAtual = novoUsuario;
    }
    
    public void fazerLogin(){
        String usuario = JOptionPane.showInputDialog("Usuario: ");
        for(Usuario u : this.usuarios){
            if (u.equalsUsuario(u, usuario)){
                while (true){
                    String senha = JOptionPane.showInputDialog("Senha: ");
                    if (u.equalsSenha(u, senha)){
                        this.usuarioAtual = u;
                        return;
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Senha errada!");
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Usuário Inexistente!");
        }
    }
    public void novoItemBiblioteca() throws ValorInvalido, PlataformaInexistente{
        this.usuarioAtual.adicionarBiblioteca();
    }
    
    public void novaPlataforma(){
        this.usuarioAtual.addPlataforma(configPlataforma());
    }
    
    public String getUsuarioAtual(){
        return this.usuarioAtual.getUsuario();
    }
    
    public String bibliotecaAtual(){
        return this.usuarioAtual.mostrarBiblioteca();
    }
}
