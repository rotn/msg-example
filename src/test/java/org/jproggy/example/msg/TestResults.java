package org.jproggy.example.msg;

import org.jproggy.snippetory.Repo;
import org.jproggy.snippetory.Template;

public class TestResults {
  private static final Template data = Repo.readResource("org/jproggy/example/msg/TestResults.html").parse();

  public static String german() {
    return data.get("german").toString();
  }
  public static String english() {
    return data.get("english").toString();
  }

}
