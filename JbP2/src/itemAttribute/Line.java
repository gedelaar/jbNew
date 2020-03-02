package itemAttribute;

import org.apache.commons.lang3.Validate;

public class Line {
  private final String line;
  private static final int MAX_LINE_LENGTH = 50;

  public Line(final String line) {

    Validate.notNull(line, "This line cannot be empty");
    Validate.inclusiveBetween(0, MAX_LINE_LENGTH, line.length(),
	"This line exceeds " + MAX_LINE_LENGTH + " characters");
    this.line = line;
  }

  public String getLine() {
    return line;
  }
}
