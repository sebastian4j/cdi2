package com.sebastian.weldse;

import jakarta.enterprise.context.Dependent;

/**
 *
 * @author Sebastián Ávila A.
 */
@Dependent
public class ServicioParaDefault implements ParaDefault {

    @Override
    public String saludar() {
        return "para-default: hola";
    }
    
}
