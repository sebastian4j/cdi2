package com.sebastian.weldse;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.enterprise.util.Nonbinding;
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
public @interface SomeQualifierTwo {
    TimeUnit value() default DAYS;
    @Nonbinding String key() default ""; // no requerido sea igual
    public static final class Literal
    extends AnnotationLiteral<SomeQualifierTwo>
    implements SomeQualifierTwo {
        private static final long serialVersionUID = 1L;
        public static final Literal INSTANCE = of(DAYS, "");
        private final TimeUnit value;
        private final String key;
        public static Literal of(TimeUnit value, String key) {
           return new Literal(value, key);
        }
        private Literal(TimeUnit value, String key) {
            this.value = value;
            this.key = key;
        }
        public TimeUnit value() {
            return value;
        }
        public String key() {
            return key;
        }
    }
}
