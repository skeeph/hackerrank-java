package me.career.treengraph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * CCIn 4.7
 */
public class TopologicalSort {
    static class Graph<T> {
        private final Map<T, List<T>>
                edges;
        private List<T> vertices;

        public Graph(List<T> vertices) {
            this.vertices = Collections.unmodifiableList(vertices);
            edges = new HashMap<>();
            vertices.forEach(vertex -> edges.putIfAbsent(vertex, new ArrayList<>()));
        }

        public void addEdge(T s, T d) {
            edges.get(s).add(d);
        }


        public List<T> topologicalSort() {
            Stack<T> stack = new Stack<T>();
            Map<T, Boolean> visited = new HashMap<>();
            vertices.forEach(x -> visited.putIfAbsent(x, false));

            for (T vertex : vertices) {
                if (!visited.get(vertex))
                    topologicalSortUtil(vertex, visited, stack);
            }

            return new ArrayList<>(stack);
        }

        private void topologicalSortUtil(T vertex, Map<T, Boolean> visited, Stack<T> stack) {
            visited.put(vertex, true);
            for (T adj : edges.get(vertex)) {
                if (!visited.get(adj)) {
                    topologicalSortUtil(adj, visited, stack);
                }
            }

            stack.push(vertex);
        }
    }

    public List<String> topoSort(List<String> vertices, List<String[]> edges) {
        Graph<String> graph = new Graph<>(vertices);
        for (String[] edge : edges) {
            if (edge.length != 2) throw new IllegalArgumentException("Для определения ребра нужны лишь 2 вершины");
            graph.addEdge(edge[0], edge[1]);
        }

        return graph.topologicalSort();
    }


    public static void main(String[] args) {
        List<String> strings = new TopologicalSort().topoSort(
                List.of("a", "b", "c", "d", "e", "f"),
                List.of(
                        new String[]{"d", "a"},
                        new String[]{"b", "f"},
                        new String[]{"d", "b"},
                        new String[]{"a", "f"},
                        new String[]{"f", "d"},
                        new String[]{"c", "d"}
                )
        );

        System.out.println(strings);
    }
}
