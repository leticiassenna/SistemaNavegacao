/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.sistemanavegacao.app;

import br.ifes.leticia.sistemanavegacao.control.Cidade;
import br.ifes.leticia.sistemanavegacao.model.AbstractAvaliadorDirecional;

/**
 *
 * @author Leticia
 */
public class Application {
    public static void main(String[] args) {
        
        Cidade cidadeSelecionada = AbstractAvaliadorDirecional.processar("Norte Dublin Belfast Edinburgh Glasgow");
        cidadeSelecionada.toString();
    }
}
