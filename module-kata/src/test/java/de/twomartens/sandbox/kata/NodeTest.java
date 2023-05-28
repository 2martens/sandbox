package de.twomartens.sandbox.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class NodeTest {

  private void doTest(Node a, Node b, boolean expected, String graphString) {
    String log = String.format("for getRoute(%s, %s) in graph:\n%s\n", a.value, b.value,
        graphString);
    boolean actual = Node.getRoute(a, b);
    assertEquals(expected, actual, log);
  }

  @Test
  void testAcyclic() {
    String ascii = "a ----> b ----> d" + "\n"
        + "↑       |" + "\n"
        + "|       |     e" + "\n"
        + "|       ↓" + "\n"
        + "|-----> c" + "\n";
    Node e = new Node("e");
    Node d = new Node("d");
    Node c = new Node("c");
    Node b = new Node("b", Arrays.asList(c, d));
    Node a = new Node("a", Arrays.asList(b, c));

    Map<Node, Map<Node, Boolean>> adjacencyMatrix = Map.of(
        a, Map.of(
            a, false, b, true, c, true, d, true, e, false),
        b, Map.of(
            a, false, b, false, c, true, d, true, e, false),
        c, Map.of(
            a, false, b, false, c, false, d, false, e, false),
        d, Map.of(
            a, false, b, false, c, false, d, false, e, false),
        e, Map.of(
            a, false, b, false, c, false, d, false, e, false));

    for (var first : adjacencyMatrix.keySet()) {
      for (var second : adjacencyMatrix.get(first).keySet()) {
        doTest(first, second, adjacencyMatrix.get(first).get(second), ascii);
      }
    }
  }

  @Test
  void testLoop() {
    String ascii = "node----" + "\n"
        + "↑      |" + "\n"
        + "|      |" + "\n"
        + "|------|" + "\n";

    Node node = new Node("node");
    node.edges = List.of(node);
    doTest(node, node, true, ascii);
  }

  @Test
  void testSimpleCyclic() {
    String ascii = "a----->b" + "\n"
        + "↑      |" + "\n"
        + "|      |       f" + "\n"
        + "|      |" + "\n"
        + "|      ↓" + "\n"
        + "d<-----c ----> e" + "\n";

    Node e = new Node("e");
    Node f = new Node("f");
    Node a = new Node("a");
    Node d = new Node("d", List.of(a));
    Node c = new Node("c", Arrays.asList(d, e));
    Node b = new Node("b", List.of(c));
    a.edges.add(b);

    Map<Node, Map<Node, Boolean>> adjacencyMatrix = Map.of(
        a, Map.of(
            a, true, b, true, c, true, d, true, e, true, f, false),
        b, Map.of(
            a, true, b, true, c, true, d, true, e, true, f, false),
        c, Map.of(
            a, true, b, true, c, true, d, true, e, true, f, false),
        d, Map.of(
            a, true, b, true, c, true, d, true, e, true, f, false),
        e, Map.of(
            a, false, b, false, c, false, d, false, e, false, f, false),
        f, Map.of(
            a, false, b, false, c, false, d, false, e, false, f, false));

    for (var first : adjacencyMatrix.keySet()) {
      for (var second : adjacencyMatrix.get(first).keySet()) {
        doTest(first, second, adjacencyMatrix.get(first).get(second), ascii);
      }
    }
  }
}