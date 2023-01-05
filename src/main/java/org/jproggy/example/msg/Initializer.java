package org.jproggy.example.msg;

import org.jproggy.snippetory.spi.Configurer;
import org.jproggy.snippetory.spi.Format;
import org.jproggy.snippetory.spi.Syntax;

public class Initializer implements Configurer {
    static {
        // the class is only loaded, so initialization goes to
        // static initializer.
        Format.register("msg",
                new ResourceFormatter("org.jproggy.example.msg.Messages"));
        Syntax.register(ResourceSyntax.INSTANCE, ResourceSyntax.INSTANCE);
    }

}
