package org.jproggy.example.msg;

import java.util.ResourceBundle;

import org.jproggy.snippetory.TemplateContext;
import org.jproggy.snippetory.spi.Configurer;
import org.jproggy.snippetory.spi.Format;
import org.jproggy.snippetory.spi.FormatConfiguration;
import org.jproggy.snippetory.spi.FormatFactory;

public class ResoureFormatFab implements FormatFactory, Configurer {

  static
  {
    // the class is only loaded, so initialization goes to
    // static initializer.
    Format.REGISTRY.register("msg", new ResoureFormatFab());
  }

  @Override
  public FormatConfiguration create(String definition, TemplateContext ctx){
    // The resource is resolved in the factory. This mean if resolving 
    // would fail, the template could not be parsed. I.e. we have a 
    // strong fail fast behavior.
    ResourceBundle msg =  ResourceBundle.getBundle(
        "org.jproggy.example.msg.Messages", ctx.getLocale());
    return new ResoureFormat(msg.getString(definition));
  } 
}