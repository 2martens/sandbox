package de.twomartens.sandbox.kata;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class NodeTest {
  private void doTest(Node a, Node b, boolean expected, String graphString) {
    String log = String.format("for getRoute(%s, %s) in graph:\n%s\n", a.value, b.value, graphString);
    boolean actual = Node.getRoute(a, b);
    assertEquals(expected, actual, log);
  }

  @Test
  void testAcyclic() {
    String ascii = "A ----> B ----> D" + "\n" +
        "↑       |" + "\n" +
        "|       |     E" + "\n" +
        "|       ↓" + "\n" +
        "|-----> C" + "\n";
    Node E = new Node("E");
    Node D = new Node("D");
    Node C = new Node("C");
    Node B = new Node("B", Arrays.asList(C, D));
    Node A = new Node("A", Arrays.asList(B, C));

    Map<Node, Map<Node, Boolean>> adjacencyMatrix = Map.of(
        A, Map.of(
            A, false, B, true, C, true, D, true, E, false),
        B, Map.of(
            A, false, B, false, C, true, D, true, E, false),
        C, Map.of(
            A, false, B, false, C, false, D, false, E, false),
        D, Map.of(
            A, false, B, false, C, false, D, false, E, false),
        E, Map.of(
            A, false, B, false, C, false, D, false, E, false));

    for (var a : adjacencyMatrix.keySet()) {
      for (var b : adjacencyMatrix.get(a).keySet()) {
        doTest(a, b, adjacencyMatrix.get(a).get(b), ascii);
      }
    }
  }

  @Test
  void testLoop() {
    String ascii = "node----" + "\n" +
        "↑      |" + "\n" +
        "|      |" + "\n" +
        "|------|" + "\n";

    Node node = new Node("node");
    node.edges = List.of(node);
    doTest(node, node, true, ascii);
  }

  @Test
  void testSimpleCyclic() {
    String ascii = "A----->B" + "\n" +
        "↑      |" + "\n" +
        "|      |       F" + "\n" +
        "|      |" + "\n" +
        "|      ↓" + "\n" +
        "D<-----C ----> E" + "\n";

    Node E = new Node("E");
    Node F = new Node("F");
    Node A = new Node("A");
    Node D = new Node("D", List.of(A));
    Node C = new Node("C", Arrays.asList(D, E));
    Node B = new Node("B", List.of(C));
    A.edges.add(B);

    Map<Node, Map<Node, Boolean>> adjacencyMatrix = Map.of(
        A, Map.of(
            A, true, B, true, C, true, D, true, E, true, F, false),
        B, Map.of(
            A, true, B, true, C, true, D, true, E, true, F, false),
        C, Map.of(
            A, true, B, true, C, true, D, true, E, true, F, false),
        D, Map.of(
            A, true, B, true, C, true, D, true, E, true, F, false),
        E, Map.of(
            A, false, B, false, C, false, D, false, E, false, F, false),
        F, Map.of(
            A, false, B, false, C, false, D, false, E, false, F, false));

    for (var a : adjacencyMatrix.keySet()) {
      for (var b : adjacencyMatrix.get(a).keySet()) {
        doTest(a, b, adjacencyMatrix.get(a).get(b), ascii);
      }
    }
  }
}