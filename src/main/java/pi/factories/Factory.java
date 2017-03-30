package pi.factories;

import java.util.function.Function;
import pi.domain.FactoryManagementResource;

public class Factory {

    public static <R extends FactoryManagementResource> R create(R resource, Function<Object, R> factory) {
        return factory.apply(resource);
    }
    
}
