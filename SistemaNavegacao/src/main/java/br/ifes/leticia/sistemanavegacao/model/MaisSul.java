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
public class MaisSul extends AbstractAvaliadorDirecional{
    private final List<Expressao> expressoes;
    
    public MaisSul(List<Expressao> expressions) {
        this.expressoes = expressions;
    }
    
    @Override
    public Cidade interpreter(String rota) {
        Cidade cidadeResultante = new Cidade("Qualquer Lugar", -999.99, -999.99);
        for (Expressao expressaoAtual: expressoes){
            Cidade cidadeAtual = expressaoAtual.interpreter(rota);
            if (cidadeAtual.getLatitude() > cidadeResultante.getLatitude()){
                cidadeResultante = cidadeAtual;
            }
        }
        return cidadeResultante;
    }

}
