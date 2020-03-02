package test.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import item.Item;
import item.TextItem;
import itemAttribute.Line;

class TextItemTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
  }

  @Test
  void test() {
    String strLine = "tekst";
     Item item = new TextItem(new Line(strLine));
     assertEquals(strLine,item.getLine().getLine());
    
  }

}
