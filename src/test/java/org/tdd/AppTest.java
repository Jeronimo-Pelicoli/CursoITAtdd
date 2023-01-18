package org.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void deveRetornarListaString() {
        App app = new App();
        List<String> exp = Arrays.asList("nome", "Composto");
        assertEquals(exp, app.converterCamelCase("nomeComposto"));
    }

    @Test
    public void deveAcontecerUmErro() {
        App app = new App();
        List<String> exp = Arrays.asList("Invalido");
        assertEquals(exp, app.converterCamelCase("nome#Composto"));
    }
}
