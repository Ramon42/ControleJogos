/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.classes;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistema.controle.de.jogos.classes.jogos.Jogo;
import sistema.controle.de.jogos.classes.plataformas.*;
import sistema.controle.de.jogos.classes.usuario.Usuario;
import sistema.controle.de.jogos.excecoes.*;
import sistema.controle.de.jogos.interfaces.IVR;

/**
 *
 * @author ramon
 */
public class ControleJogos {
    private ArrayList<Usuario> usuarios = new ArrayList();
    private Usuario usuarioAtual;
    
    private Plataforma configPlataforma(){
        Plataforma plataforma = null;
        int opcPlat = Integer.parseInt(JOptionPane.showInputDialog("Plataforma: \n"
                + "1- XBox One\n"
                + "2- PlayStation 4\n"
                + "3- Nintendo Switch\n"
                + "4- PC\n"));
        switch(opcPlat){
            case 1:
                plataforma = new XBoxOne();
                break;
            case 2:
                plataforma = new PS4();
                break;
            case 3:
                plataforma = new Switch();
                break;
            case 4:
                plataforma = new Pc();
                break;
        }
        return (plataforma);
    }
    
    public void addNovoUsuario(){
        String login, senha;
        Usuario novoUsuario = new Usuario();
        login = JOptionPane.showInputDialog("Login novo usuário: ");
        senha = JOptionPane.showInputDialog("Senha novo usuário(min. 8 caracteres): ");
        novoUsuario.setUsuario(login);
        novoUsuario.setSenha(senha);
        this.usuarios.add(novoUsuario);
        this.usuarioAtual = novoUsuario;
        this.usuarioAtual.addPlataforma(configPlataforma());
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
                    else{
                        JOptionPane.showMessageDialog(null, "Senha errada ou o usuário não esta cadastrado!");
                        return;
                    }
                }
            }
        }
        
    }
    public void novoItemBiblioteca() throws PlataformaInexistente{
        this.usuarioAtual.adicionarBiblioteca(1);
    }
    
    public void addListaDesejo() throws PlataformaInexistente{
        this.usuarioAtual.adicionarBiblioteca(2);
        
    }
    
    public void novaPlataforma(){
        this.usuarioAtual.addPlataforma(configPlataforma());
    }
    
    public String getUsuarioAtual(){
        return this.usuarioAtual.getUsuario();
    }
    
    //usar sobrecarga
    public String bibliotecaAtual(){
        return this.usuarioAtual.mostrarBiblioteca(1);
    }
    public String listaDesejo(){
        return this.usuarioAtual.mostrarBiblioteca(2);
    }
    //
    public void excluirJogo(String titulo){
        this.usuarioAtual.excluir(titulo);
    }
    public void organizarPorTitulo(){
        this.usuarioAtual.organizar(1);
    }
    public void organizarPorTema(){
        this.usuarioAtual.organizar(2);
    }
    public void organizarPorValor(){
        this.usuarioAtual.organizar(3);
    }
    public void configuracoesPlats(){
        Plataforma aux;
        ArrayList<Jogo> auxExclusivo = new ArrayList();
        ArrayList<Jogo> biblioteca = this.usuarioAtual.getBiblioteca();
        int conf = Integer.parseInt(JOptionPane.showInputDialog("Selecione o que deseja configurar: "
            + "\n1- Adquirir VR para uma plataforma;"
            + "\n2- Ver jogos exclusivos;"));
        int opcPlat = Integer.parseInt(JOptionPane.showInputDialog("Plataforma: \n"
            + "1- XBox One\n"
            + "2- PlayStation 4\n"
            + "3- Nintendo Switch\n"
            + "4- PC\n"));
        aux = this.usuarioAtual.getPlataformasValidasUsuario(opcPlat);
        if (aux != null){
            switch(conf){
                case 1:
                    if(aux instanceof IVR){
                        ((IVR) aux).adquirirVR();
                    }
                    else
                        JOptionPane.showInputDialog("Plataforma não suporta VR.");
                    break;
                case 2:
                    for(Jogo x : biblioteca){
                        if (x.getCodExclusivo() == opcPlat){
                            auxExclusivo.add(x);
                        }
                    }
                    JOptionPane.showMessageDialog(null, this.usuarioAtual.mostrarBiblioteca(auxExclusivo));
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuário não possui essa plataforma.");
        }
    }
}
