package com.sebastian.weldse.eventos;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.ObservesAsync;

/**
 *
 * @author Sebastián Ávila A.
 */
@Dependent
public class ObservadorDosAsync {
    // si hay exception otros observadores si seran llamados
    private void Observa(@ObservesAsync String msj) {
        System.out.println("async: " + msj);
    }
}
