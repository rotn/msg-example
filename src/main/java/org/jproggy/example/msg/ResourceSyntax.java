package org.jproggy.example.msg;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import org.jproggy.snippetory.TemplateContext;
import org.jproggy.snippetory.util.RegExSyntax;
import org.jproggy.snippetory.util.Token.TokenType;
import org.jproggy.snippetory.spi.SyntaxID;

/**
 *
 * @author Bernd Ebertz
 *
 */
public class ResourceSyntax extends RegExSyntax implements SyntaxID {

  protected static final String NAMED_LOC = "%(" + NAME + ")%";
  static final ResourceSyntax INSTANCE = new ResourceSyntax();

  /**
   *  a template context pre-configured for selected syntax
   */
  public static TemplateContext context() {
    return new TemplateContext().syntax((SyntaxID) INSTANCE);
  }

  /**
   *  a template context pre-configured for selected syntax
   */
  public static TemplateContext context(Locale l) {
    return context().locale(l);
  }

  @Override
  public RegexParser parse(CharSequence data, TemplateContext ctx) {
    Map<Pattern, TokenType> patterns = new LinkedHashMap<>();

    patterns.put(SYNTAX_SELECTOR, TokenType.Syntax);

    Pattern field = Pattern.compile(NAMED_LOC, Pattern.MULTILINE);
    patterns.put(field, TokenType.Field);

    return new RegexParser(data, ctx, patterns);
  }

  @Override
  public String getName() {
    return "msg";
  }
}
