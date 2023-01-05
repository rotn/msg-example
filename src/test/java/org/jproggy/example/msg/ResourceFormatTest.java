package org.jproggy.example.msg;

import static java.util.Locale.GERMAN;

import static java.util.Locale.US;
import static org.jproggy.snippetory.Encodings.html;
import org.jproggy.snippetory.Repo;
import org.jproggy.snippetory.Template;
import org.jproggy.snippetory.toolyng.test.Normalize;
import org.junit.Test;

public class ResourceFormatTest {

  @Test
  public void german() {
    Template tpl = Repo.readResource("HalloWorldApp.html").encoding(html).locale(GERMAN).parse();
    Normalize.assertNormEquals(TestResults.german(), tpl.toString());
  }

  @Test
  public void english() {
    Template tpl = Repo.readResource("HalloWorldApp.html").encoding(html).locale(US).parse();
    Normalize.assertNormEquals(TestResults.english(), tpl.toString());
  }

}
