/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.sistemanavegacao.model;

import br.ifes.leticia.sistemanavegacao.control.Cidade;
import br.ifes.leticia.sistemanavegacao.control.Expressao;
import java.util.List;

/**
 *
 * @author Leticia
 */
public class MaisNorte implements Expressao{
    private final List<Expressao> expressoes;
    
    public MaisNorte(List<Expressao> expressions) {
        this.expressoes = expressions;
    }
    
    @Override
    public Cidade interpreter() {
        Cidade cidadeResultante = new Cidade("Qualquer Lugar", -999.99, -999.99);
        for (Expressao expressaoAtual: expressoes){
            Cidade cidadeAtual = expressaoAtual.interpreter();
            if (cidadeAtual.getLatitude() > cidadeResultante.getLatitude()){
                cidadeResultante = cidadeAtual;
            }
        }
        return cidadeResultante;
    }
}
