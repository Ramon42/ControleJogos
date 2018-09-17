/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos;

import javax.swing.JOptionPane;
import sistema.controle.de.jogos.classes.ControleJogos;
import sistema.controle.de.jogos.excecoes.*;

/**
 *
 * @author ramon
 */
public class Main {
    public static void main(String[] args) throws PlataformaInexistente {
        ControleJogos controle = new ControleJogos();
        int opcao, org;
        String auxExcluir;
        
        controle.addNovoUsuario();
        
        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Usuário: "+controle.getUsuarioAtual()
                    + "\n\n 1- Adicionar novo jogo à biblioteca;"
                    + "\n 2- Adicionar novo jogo à lista de desejos;"
                    + "\n 3- Adicionar plataforma;"
                    + "\n 4- Mostrar biblioteca;"
                    + "\n 5- Mostrar lista de desejos;"
                    + "\n 6- Organizar biblioteca;"
                    + "\n 7- Remover jogo da lista de desejos;"
                    + "\n 8- Opções de console;"
                    + "\n 9- Adicionar Usuário;"
                    + "\n 10- Trocar Usuário;"
                    + "\n 15- Fechar programa.")); //sugerir jogos com hype baixo
            switch(opcao){
                case 1:
                    controle.novoItemBiblioteca();
                    break;
                case 2:
                    controle.addListaDesejo();
                    break;
                case 3:
                    controle.novaPlataforma();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, controle.bibliotecaAtual());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, controle.listaDesejo());
                    break;
                case 6:
                    org = Integer.parseInt(JOptionPane.showInputDialog("Selecione o tipo de organização: "
                            + "\n1- Organizar Por Titulo"
                            + "\n2- Organizar Por Tema"
                            + "\n3- Organizar Por Valor"));
                    switch(org){
                        case 1:
                            controle.organizarPorTitulo();
                            break;
                        case 2:
                            controle.organizarPorTema();
                            break;
                        case 3:
                            controle.organizarPorValor();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida!");
                            break;
                    }
                    break;
                case 7:
                    auxExcluir = JOptionPane.showInputDialog("Digite o titulo que deseja excluir: \n\n" + controle.listaDesejo());
                    controle.excluirJogo(auxExcluir);
                    break;
                case 8:
                    
                    break;
                case 9:
                    controle.addNovoUsuario();
                    break;
                case 10:
                    controle.fazerLogin();
                    break;
            }
        }while (opcao != 15); 
    }
    
}
