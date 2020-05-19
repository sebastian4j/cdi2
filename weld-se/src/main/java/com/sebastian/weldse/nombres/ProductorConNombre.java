package com.sebastian.weldse.nombres;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

/**
 *
 * @author Sebastián Ávila A.
 */
@ApplicationScoped
public class ProductorConNombre {
    @Produces
    @Named("productorConNombre")
    public ServicioConNombre producir() {
        return () -> "con nombre producido";
    }
}
