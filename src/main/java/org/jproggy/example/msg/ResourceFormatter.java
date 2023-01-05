package org.jproggy.example.msg;

import java.util.ResourceBundle;
import java.util.Set;

import org.jproggy.snippetory.Template;
import org.jproggy.snippetory.TemplateContext;
import org.jproggy.snippetory.spi.FormatConfiguration;
import org.jproggy.snippetory.spi.FormatFactory;
import org.jproggy.snippetory.util.SimpleFormat;
import org.jproggy.snippetory.util.TemplateNode;
import org.jproggy.snippetory.spi.VoidFormat;

public class ResourceFormatter implements FormatFactory {
  private final String baseName;

  public ResourceFormatter(String baseName) {
    this.baseName = baseName;
  }

  @Override
  public FormatConfiguration create(String definition, TemplateContext ctx){
    // The resource is resolved in the factory. This means, if resolving
    // would fail, the template could not be parsed. I.e. we have a
    // strong fail fast behavior.
    ResourceBundle msg =  ResourceBundle.getBundle(baseName, ctx.getLocale());
    String resolved = msg.getString(definition);
    return new Msg(ResourceSyntax.context(ctx.getLocale()).parse(resolved));
  }

  private static class Msg extends SimpleFormat implements VoidFormat {
    private final Template resolved;

    public Msg(Template resolved) {
      this.resolved = resolved;
    }

    @Override
    public Object formatVoid(TemplateNode node) {
      return resolved;
    }

    @Override
    public void set(String name, Object value) {
      resolved.set(name, value);
    }

    @Override
    public void append(String name, Object value) {
      resolved.append(name, value);
    }

    @Override
    public Set<String> names() {
      return resolved.names();
    }
  }
}