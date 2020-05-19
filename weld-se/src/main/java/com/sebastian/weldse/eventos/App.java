package com.sebastian.weldse.eventos;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author Sebastián Ávila A.
 */
public class App {
    public static void main(String[] args) {
        Weld weld = new Weld();
        try ( WeldContainer wc = weld.initialize()) {
            wc.select(EnviadorUno.class).get().enviar("hola!");
        }
    }
    
}
