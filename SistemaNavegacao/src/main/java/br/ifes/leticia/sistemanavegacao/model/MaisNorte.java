/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.sistemanavegacao.model;

import br.ifes.leticia.sistemanavegacao.control.Cidade;
import br.ifes.leticia.sistemanavegacao.control.Expressao;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Leticia
 */
public class MaisNorte extends AbstractAvaliadorDirecional{
    
    public MaisNorte(){
        this.direcao = "Norte";
    }
    
    @Override
    protected String[] matchingWords() {
        return new String[]{"Norte"};
    }
    
    @Override
    public Cidade executar(Stack<Cidade> expressoes) {
        Cidade cidadeResultante = this.cidadeAtual;
        while(!expressoes.empty()){
            Cidade token = expressoes.pop();
            if(cidadeResultante.getLatitude()< token.getLatitude()){
                cidadeResultante = token;
            }
        }
        return cidadeResultante;
    }

    
    
}
