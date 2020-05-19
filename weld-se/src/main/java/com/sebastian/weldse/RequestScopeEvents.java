package com.sebastian.weldse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.BeforeDestroyed;
import jakarta.enterprise.context.Destroyed;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Observes;

/**
 *
 * @author Sebastián Ávila A.
 */
@ApplicationScoped
public class RequestScopeEvents {

    public void inicializados(@Observes
            @Initialized(RequestScoped.class) Object o) {
        System.out.println("RequestScope: inicializado");
    }

    public void preDestruido(@Observes
            @BeforeDestroyed(RequestScoped.class) Object o) {
        System.out.println("RequestScope: pre-destruido");
    }

    public void destruido(@Observes
            @Destroyed(RequestScoped.class) Object o) {
        System.out.println("RequestScope: destruido");
    }
}
