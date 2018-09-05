/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controle.de.jogos.excecoes;

/**
 *
 * @author ramon
 */
public class PlataformaInexistente extends Exception{
    public PlataformaInexistente(String exc){
        super("Exceção: Plataforma não existe");
    }
}