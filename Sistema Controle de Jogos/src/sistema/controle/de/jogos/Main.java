/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos;

import javax.swing.JOptionPane;
import sistema.controle.de.jogos.classes.ControleJogos;
import sistema.controle.de.jogos.classes.Plataforma;
import sistema.controle.de.jogos.classes.jogos.Jogo;
import sistema.controle.de.jogos.classes.usuario.Usuario;
import sistema.controle.de.jogos.excecoes.*;

/**
 *
 * @author ramon
 */
public class Main {
    public static void main(String[] args) throws ValorInvalido, PlataformaInexistente {
        ControleJogos controle = new ControleJogos();
        int opcao;
        
        
        controle.addNovoUsuario();
        
        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Usuário: "+controle.getUsuarioAtual()
                    + "\n\n 1- Adicionar novo jogo à biblioteca;"
                    + "\n 2- Adicionar novo jogo à lista de desejos;"
                    + "\n 3- Adicionar plataforma;"
                    + "\n 4- Mostrar biblioteca;"
                    + "\n 5- Mostrar lista de desejos;"
                    + "\n 6- Remover jogo da lista de desejos;"
                    + "\n 7- Adicionar Usuário;"
                    + "\n 8- Trocar Usuário;"
                    + "\n 9- Fechar programa.")); //sugerir jogos com hype baixo
            switch(opcao){
                case 1:
                    controle.novoItemBiblioteca();
                    break;
                case 3:
                    controle.novaPlataforma();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, controle.bibliotecaAtual());
                    break;
                case 7:
                    controle.addNovoUsuario();
                    break;
                case 8:
                    controle.fazerLogin();
                    break;
            }
        }while (opcao != 9); 
    }
    
}
