/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.sistemanavegacao.model;

import br.ifes.leticia.sistemanavegacao.control.Cidade;
import br.ifes.leticia.sistemanavegacao.control.Expressao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Leticia
 */
public abstract class AbstractAvaliadorDirecional implements Expressao{
    private final Map<String, Cidade> cidades;
    protected Expressao proximo;
    
    public AbstractAvaliadorDirecional(){
        cidades = new HashMap<>();
        
        cidades.put("aberdeen", new Cidade("Aberdeen", 57.15, -2.15));
        cidades.put("belfast", new Cidade("Belfast", 54.62, -5.93));
        cidades.put("birmingham", new Cidade("Birmingham", 52.42, -1.92));
        cidades.put("dublin", new Cidade("Dublin", 53.33, -6.25));
        cidades.put("edinburgh", new Cidade("Edinburgh", 55.83, -4.25));
        cidades.put("glasgow", new Cidade("Glasgow", 55.92, -4.25));
        cidades.put("london", new Cidade("London", 51.53, -0.08));
        cidades.put("liverpool", new Cidade("Liverpool", 53.42, -3.0));
        cidades.put("manchester", new Cidade("Manchester", 53.5, -2.25));
        cidades.put("southampton", new Cidade("Southampton", 50.9, -1.38));
        
    }
    
    public static Cidade processar(String entrada){
        
        Expressao leste = new MaisLeste(null);
        Expressao norte = new MaisNorte(null);
        Expressao oeste = new MaisOeste(null);
        Expressao sul = new MaisSul(null);
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
        Stack<Expressao> expressaoStack = new Stack<>();
        
        for (String token: rota.split(" ")){
            if (cidades.containsKey(token)){
                Cidade cidade = cidades.get(rota);
                expressaoStack.push(new ExpressaoCidade(cidade));
                
            }else if (token.equals("Norte")){
                expressaoStack.push(new MaisNorte(carregarExpressoes(expressaoStack)));
                
            }else if (token.equals("Sul")){
                expressaoStack.push(new MaisSul(carregarExpressoes(expressaoStack)));
                
            }else if (token.equals("Leste")){
                expressaoStack.push(new MaisLeste(carregarExpressoes(expressaoStack)));
                
            }else {
                expressaoStack.push(new MaisOeste(carregarExpressoes(expressaoStack)));
            }
        }
        return expressaoStack.pop().interpreter(rota);
    }
    
    private List<Expressao> carregarExpressoes(Stack<Expressao> expressoesStack){
        List<Expressao> expressoes = new ArrayList<>();
        
        while (!expressoesStack.empty()){
            expressoes.add(expressoesStack.pop());
        }
        return expressoes;
    }
}
