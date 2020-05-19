package com.sebastian.weldse;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
//import jakarta.el.ELProcessor;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.control.RequestContextController;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.jboss.weld.context.activator.ActivateRequestContext;

/**
 *
 * @author Sebastián Ávila A.
 */
@Dependent
public class Injectado {
    @Inject
    @SomeQualifierOne(TimeUnit.DAYS)
    private OtroServicio os;
    @Inject
    @SomeQualifierThree(value = TimeUnit.DAYS, key = "hola")
    private OtroServicio os31;
    @Inject
    @SomeQualifierThree(value = TimeUnit.DAYS, key = "chao")
    private OtroServicio os32;
    @Inject
    BeanManager bm;
    @Inject
    @Any
    Instance<OtroServicio> multiple;
    private OtroServicio desdeMetodo;
    
    @Inject
    private RequestContextController rcc;
    
    @Inject
    // it’s not necessary (or even possible) to annotate the individual parameters with @Inject
    public void metodo(BeanManager bm, @SomeQualifierOne(TimeUnit.DAYS) OtroServicio os) {
        desdeMetodo = os;
        rcc.activate();
        try {
            // algo que ocupe request scope
        } finally {
            rcc.deactivate();
        }
    }
    
    @PostConstruct
    @ActivateRequestContext // permite acticar el request context
    private void post() {
        System.out.println("injectado: post");
    }
    
    public void saludar() {
        System.out.println("os31: " + os31.saludar());
        System.out.println("os32: " + os32.saludar());
        System.out.println("multi: " + multiple.stream().collect(Collectors.toList()).size());        
        System.out.println("metodo: " + desdeMetodo);
//        ELProcessor elProcessor = new ELProcessor();
//         elProcessor.getELManager()
//                    .addELResolver(
//                        bm.getELResolver());
//        ConNombre cn =
//            (ConNombre) elProcessor.getValue(
//                "conNombre", ConNombre.class);
//        System.out.println("bm: " + cn.saludar());
    }
    
    @PreDestroy
    private void pre() {
        System.out.println("injectado: pre");
    }
}
