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
public class ValorInvalido extends RuntimeException {
    public ValorInvalido(String exc){
        super("Exceção: Plataforma não existe");
    }
}
