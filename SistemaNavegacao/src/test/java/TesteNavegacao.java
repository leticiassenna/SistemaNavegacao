/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.ifes.leticia.sistemanavegacao.control.Expressao;
import br.ifes.leticia.sistemanavegacao.model.MaisLeste;
import br.ifes.leticia.sistemanavegacao.model.MaisNorte;
import br.ifes.leticia.sistemanavegacao.model.MaisOeste;
import br.ifes.leticia.sistemanavegacao.model.MaisSul;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leticia
 */
public class TesteNavegacao {
    
    public TesteNavegacao() {
    }
    
    @Test
    public void TesteSentido(){
        MaisLeste leste = new MaisLeste();
        Assert.assertEquals("Leste", leste.getDirecao());
    }
    
    @Test
    public void TesteProximo(){
        MaisLeste leste = new MaisLeste();
        MaisNorte norte = new MaisNorte();
        leste.proximaExpressao(norte);
        Assert.assertEquals(norte, leste.getProximo());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
