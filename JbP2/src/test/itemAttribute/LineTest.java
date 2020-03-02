package test.itemAttribute;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import itemAttribute.Line;

class LineTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
  }

  @Test
  void lineTest() {
    Line line;
    String strLine = "test";
    line = new Line("test");
    assertEquals(strLine, line.getLine());
  }

  @Test
  void illegalArgumentExceptionTest() {

    assertThrows(IllegalArgumentException.class, () -> {
      String strLine = "123456789012345678901234567890123456789012345678901234567890";
      Line line = new Line(strLine);
    });
  }

  @Test
  void nullPointerExceptionTest() {
    assertThrows(NullPointerException.class, () -> {
      String strLine = null;
      Line line = new Line(strLine);
    });

  }

}
