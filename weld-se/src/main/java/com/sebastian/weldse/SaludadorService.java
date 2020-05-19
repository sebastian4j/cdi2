package com.sebastian.weldse;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Typed;

/**
 *
 * @author Sebastián Ávila A.
 */
@Dependent
@Typed(SaludadorService.class) // <- se obtiene solo con esa clase y no con la interface
public class SaludadorService implements Servicio {

  @PostConstruct
  private void post() {
    System.out.println("saludador: post");
  }

  @PreDestroy
  private void pre() {
    System.out.println("saludador: pre");
  }

  @Override
  public String saludar() {
    return "saludador: hola";
  }
}
