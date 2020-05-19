package com.sebastian.weldse.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;

/**
 *
 * @author Sebastián Ávila A.
 */
@ApplicationScoped
//@Dependent // puede ser
public class EnviadorUno {

    @Inject
    // si define calificadores, serán usandos al lanzar el evento
    // diferente al bean manager
    private Event<String> eventoSinCalificacion;

    @Inject
    private BeanManager beanManager;

    public void enviar(String string) {
        eventoSinCalificacion.fireAsync("hola async!")
                .handle((ev, exce) -> { // exception del stage anterior
                    if (exce != null) {
                        for (Throwable suppressed : exce.getSuppressed()) {
                            //...
                        }
                    }
                    System.out.println("error: " + exce);
                    return 1; // para la siguiente stage
                })
                .thenAccept(s -> {
                    System.out.println("then: " + (s + 7)); // s es el mismo evento se se retorna ev
                }).thenRun(() -> {
            System.out.println("runnable");
        });
        eventoSinCalificacion.fire(string);
        beanManager.getEvent().select(String.class,
                Default.Literal.INSTANCE // opcional, el calificador
        ).fire("desde el bean manager");
    }

}
