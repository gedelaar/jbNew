package item;

import java.util.List;

public interface Item {
  String/* No type specified! */ getLine();

  void writeLine();

  void node();

  String setNodeNaam(String naam);

  String getNodeNaam();

  NodeAttribute getNodeAttribute(int index);

  List<NodeAttribute> getNodeAttributes();
}
