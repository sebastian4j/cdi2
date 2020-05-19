package com.sebastian.weldse;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Typed;

/**
 *
 * @author Sebastián Ávila A.
 */
@Dependent
@Typed(TypedService.class) // solo se puede acceder con la clase, no con la interface
public class TypedService implements Servicio {

  @Override
  public String saludar() {
    return "typed";
  }
  
}
