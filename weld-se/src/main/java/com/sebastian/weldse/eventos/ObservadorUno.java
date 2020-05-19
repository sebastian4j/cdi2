package com.sebastian.weldse.eventos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.EventMetadata;

/**
 *
 * @author Sebastián Ávila A.
 */
@ApplicationScoped
public class ObservadorUno {
    // - solo un @Observes
    // - puede ser List<String>, List<?> pero en runtime será List
    // -- usar un wrapper para eso
    // - se pueden usar calificadores:
    // - si el evento tiene 3 calificadores y el metodo usa alguno o todos ellos
    // el metodo recibe el evento
    // - si no cumple con alguno no recibe el evento
    // - pueden sobrar calificadores pero no faltar
    // - usando @Default es solo sin calificadores
    // - @Observes(notifyObserver = IF_EXISTS)
    // - @Observes(notifyObserver = ALWAYS)
    // - @Observes @Priority(Interceptor.Priority.APPLICATION)
    // - en la prioridad, el menor numero es invocado antes
/*
• PLATFORM_BEFORE
• LIBRARY_BEFORE
• APPLICATION <<
• LIBRARY_AFTER <<
• PLATFORM_AFTER
     */
    // APPLICATION + 500 es usado cuando no se define prioridad
    // - cuando se lanza una exception no se llaman a los demás listeners del evento
    // (un evento tiene n listeners)
/* Observes.during en transaction:
• IN_PROGRESS: default, any observer method is automatically a transactional observer
• BEFORE_COMPLETION
• AFTER_COMPLETION (bien o mal)
• AFTER_SUCCESS
• AFTER_FAILURE
*/
    // - asyncronos no propagan transacciones
    // - que built-in scopes no son propagados a background threads
    private void observa(@Observes String mensaje, EventMetadata em) {
        System.out.println("recibido: " + mensaje);
        if (em != null && em.getInjectionPoint() != null && em.getInjectionPoint()
                    .getBean() != null) {
            System.out.println("desde: " + em.getInjectionPoint()
                    .getBean().getBeanClass().getCanonicalName());
        }
    }
}
