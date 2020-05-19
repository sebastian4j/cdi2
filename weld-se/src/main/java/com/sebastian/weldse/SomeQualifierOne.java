package com.sebastian.weldse;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.DAYS;

/**
 *
 * @author Sebastián Ávila A.
 */
@Qualifier
@Retention(RUNTIME)
@Target({ TYPE, METHOD, FIELD, PARAMETER })
@Documented
public @interface SomeQualifierOne {
    TimeUnit value() default DAYS;
    public static final class Literal
        extends AnnotationLiteral<SomeQualifierOne> implements SomeQualifierOne {
        private static final long serialVersionUID = 1L;
        public static final Literal INSTANCE = of(DAYS);
        private final TimeUnit value;
        public static Literal of(TimeUnit value) {
            return new Literal(value);
        }
        private Literal(TimeUnit value) {
            this.value = value;
        }
        public TimeUnit value() {
            return value;
        }
    }
}