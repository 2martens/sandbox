package de.twomartens.sandbox.kata;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString(onlyExplicitlyIncluded = true)
final class Node {

  @ToString.Include
  String value;
  List<Node> edges = new ArrayList<>();

  public Node(String value) {
    this.value = value;
  }

  public Node(String value, List<Node> edges) {
    this.value = value;
    this.edges = edges;
  }

  public static boolean getRoute(Node a, Node b) {
    // return whether there is a route from a to b
    log.info("Calculate route from %s to %s".formatted(a, b));
    Collection<Node> visitedNodes = new HashSet<>();

    boolean traversable = a.edges.stream().anyMatch(node -> node.value.equals(b.value));
    if (traversable) {
      return true;
    }

    Queue<Node> toVisitNodes = new ArrayDeque<>(a.edges);
    while (!toVisitNodes.isEmpty()) {
      Node c = toVisitNodes.poll();
      visitedNodes.add(c);
      traversable = c.edges.stream()
          .filter(node -> !visitedNodes.contains(node))
          .peek(toVisitNodes::add)
          .anyMatch(node -> node.value.equals(b.value));
      if (traversable) {
        return true;
      }
    }

    return false;
  }
}