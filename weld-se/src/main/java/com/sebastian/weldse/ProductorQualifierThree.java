package com.sebastian.weldse;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Sebastián Ávila A.
 */
@ApplicationScoped
public class ProductorQualifierThree {

    @PostConstruct
    private void post() {
        System.out.println("productor-3: post");
    }

    @Produces
    @SomeQualifierThree(TimeUnit.DAYS)
    public OtroServicio produce(InjectionPoint ip) {
        final var ga = ip.getAnnotated();
        String key = null;
        if (ga != null && ip.getAnnotated() != null && ip.getAnnotated()
                        .getAnnotation(SomeQualifierThree.class) != null) {
            key = ip.getAnnotated()
                        .getAnnotation(SomeQualifierThree.class)
                        .key();
        }
        System.out.println("produciendo: " + key);
        if ("hola".equals(key)) {
            return () -> "holas!!";
        } else {
            return () -> "no hola!!";
        }
    }
}
