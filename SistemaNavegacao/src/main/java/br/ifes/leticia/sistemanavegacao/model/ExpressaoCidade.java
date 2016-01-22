/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.sistemanavegacao.model;

import br.ifes.leticia.sistemanavegacao.control.Cidade;
import br.ifes.leticia.sistemanavegacao.control.Expressao;

/**
 *
 * @author Leticia
 */
public class ExpressaoCidade implements Expressao{
    private final Cidade cidade;
    
    public ExpressaoCidade(Cidade city){
        this.cidade = city;
    }
    
    @Override
    public Cidade interpreter(String rota) {
        return cidade;
    }

    @Override
    public void proximaExpressao(Expressao proximo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
