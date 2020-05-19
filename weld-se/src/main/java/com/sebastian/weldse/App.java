package com.sebastian.weldse;

import com.sebastian.weldse.nombres.ServicioConNombre;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.literal.NamedLiteral;
import jakarta.enterprise.inject.spi.CDI;
import java.util.concurrent.TimeUnit;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author Sebastián Ávila A.
 */
public class App {

    public static void main(String[] args) {
        Weld weld = new Weld();
        try ( WeldContainer wc = weld.initialize()) {
            // usando types
            System.out.println(CDI.current().select(TypedService.class).get().saludar());
            System.out.println(CDI.current().select(Servicio.class).get().saludar());
            System.out.println(wc.select(SaludadorService.class).get().saludar());
            // types + qualifiers
            System.out.println(wc.select(
                    OtroServicio.class,
                    SomeQualifierOne.Literal.of(TimeUnit.HOURS)
            ).get().saludar());
            System.out.println(wc.select(OtroServicio.class,
                    SomeQualifierOne.Literal.of(TimeUnit.DAYS)).get().saludar());
            //
            System.out.println(wc.select(OtroServicio.class,
                    SomeQualifierTwo.Literal.of(TimeUnit.DAYS, "")).get().saludar());
            System.out.println(wc.select(OtroServicio.class,
                    SomeQualifierTwo.Literal.of(TimeUnit.DAYS, "holi")).get().saludar());
            // no se puede usar el ProductorQualifierThree programaticamente
            wc.select(Injectado.class).get().saludar();
            // con nombre
            System.out.println(wc.select(ServicioConNombre.class,
                    NamedLiteral.of("conNombre")).get().saludar());
            System.out.println(wc.select(ServicioConNombre.class,
                    NamedLiteral.of("productorConNombre")).get().saludar());
            System.out.println("::multiples::");
            // multiples
            Instance<OtroServicio> otrosServicios
                    = CDI.current()
                            .select(
                                    OtroServicio.class,
                                     Any.Literal.INSTANCE // todos los beans que la implementen y cumplan el @Typed si existe
                            );
            otrosServicios.forEach(cs -> {
                System.out.println("any: " + cs.saludar());
            });
            // una interface puede tener varias implementaciones
            Instance<ParaDefault> paradefault = CDI.current().select(ParaDefault.class, 
                    Any.Literal.INSTANCE);
            // pero se obtiene solo la que sea default
            Instance<ParaDefault> serviciodefault = paradefault.select(
                            Default.Literal.INSTANCE);
            System.out.println("otros no tiene default?:" + serviciodefault.isUnsatisfied());
            System.out.println("otros se obtiene?:" + serviciodefault.isResolvable());
        }
    }
}
