/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.sistemanavegacao.model;

import br.ifes.leticia.sistemanavegacao.control.Cidade;
import br.ifes.leticia.sistemanavegacao.control.Expressao;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Leticia
 */
public abstract class AbstractAvaliadorDirecional implements Expressao{
    private final Map<String, Cidade> cidades;
    protected Expressao proximo;
    protected String direcao;
    protected Cidade cidadeAtual;
    protected abstract Cidade executar(Stack<Cidade> expressoes);
    protected abstract String[] matchingWords();
    
    public AbstractAvaliadorDirecional(){
        cidades = new HashMap<>();
        
        cidades.put("Aberdeen", new Cidade("Aberdeen", 57.15, -2.15));
        cidades.put("Belfast", new Cidade("Belfast", 54.62, -5.93));
        cidades.put("Birmingham", new Cidade("Birmingham", 52.42, -1.92));
        cidades.put("Dublin", new Cidade("Dublin", 53.33, -6.25));
        cidades.put("Edinburgh", new Cidade("Edinburgh", 55.83, -4.25));
        cidades.put("Glasgow", new Cidade("Glasgow", 55.92, -4.25));
        cidades.put("London", new Cidade("London", 51.53, -0.08));
        cidades.put("Liverpool", new Cidade("Liverpool", 53.42, -3.0));
        cidades.put("Manchester", new Cidade("Manchester", 53.5, -2.25));
        cidades.put("Southampton", new Cidade("Southampton", 50.9, -1.38));
        
    }
    
    public static Cidade processar(String entrada){
        
        Expressao leste = new MaisLeste();
        Expressao norte = new MaisNorte();
        Expressao oeste = new MaisOeste();
        Expressao sul = new MaisSul();
        leste.proximaExpressao(norte);
        norte.proximaExpressao(oeste);
        oeste.proximaExpressao(sul);
        
        return leste.interpreter(entrada);
    }
    
    @Override
    public void proximaExpressao(Expressao proximo) {
        this.proximo = proximo;
    }
    
    @Override
    public Cidade interpreter(String rota){
        Stack<Cidade> expressoes = new Stack<>();
        boolean palavraEncontrada = false;
        
        if(matchingWords().length == 0){
            palavraEncontrada = true;
        }
       
        for(String token: matchingWords()){
            if(cidades.containsKey(token)){
                expressoes.push(cidades.get(token));
            }
        }
        
        for(String token: rota.split(" ")){
            if(direcao.equals(token) || palavraEncontrada == true){
                palavraEncontrada = true;
                this.cidadeAtual = executar(expressoes);
            } 
            else {
                this.cidadeAtual = proximo.interpreter(rota);
            }
        }
        
        return this.cidadeAtual;
    }
}
