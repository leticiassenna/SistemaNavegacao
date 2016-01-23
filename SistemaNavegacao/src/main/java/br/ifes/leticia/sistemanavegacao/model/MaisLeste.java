/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.sistemanavegacao.model;

import br.ifes.leticia.sistemanavegacao.control.Cidade;
import java.util.Stack;

/**
 *
 * @author Leticia
 */
public class MaisLeste extends AbstractAvaliadorDirecional{
    
    public MaisLeste() {
        this.direcao = "Leste";
    }
    
    @Override
    public Cidade executar(Stack<Cidade> expressoes) {
        Cidade cidadeResultante = this.cidadeAtual;
        while(expressoes.empty() == false){
            Cidade token = expressoes.pop();
            if(cidadeResultante.getLongitude()< token.getLongitude()){
                cidadeResultante = token;
            }
        }
        return cidadeResultante;
    }

}
