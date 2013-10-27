package org.jproggy.example.msg;

import java.util.Collections;
import java.util.Set;

import org.jproggy.snippetory.spi.SimpleFormat;
import org.jproggy.snippetory.spi.TemplateNode;
import org.jproggy.snippetory.spi.VoidFormat;

public class ResoureFormat extends SimpleFormat implements VoidFormat {
  private final String resolved;

  public ResoureFormat(String resolved) {
    this.resolved =  resolved;
  }

  @Override
  public Object formatVoid(TemplateNode node) {
    return resolved;
  }

  @Override
  public boolean supports(Object value) {
    return false;
  }

  @Override
  public String format(TemplateNode node, Object value) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public void set(String name, Object value) {
  }

  @Override
  public void append(String name, Object value) {
  }

  @Override
  public Set<String> names() {
    return Collections.emptySet();
  }
  
}