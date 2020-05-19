package com.sebastian.weldse.nombres;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

/**
 *
 * @author Sebastián Ávila A.
 */
@Dependent
@Named
public class ConNombre implements ServicioConNombre {

    @Override
    public String saludar() {
        return this.getClass().getCanonicalName();
    }
   
}
