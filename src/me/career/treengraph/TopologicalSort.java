package me.career.treengraph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * CCIn 4.7
 */
public class TopologicalSort {
    private static class CycleException extends RuntimeException {

    }

    public static final Integer WHITE=0;
    public static final Integer GRAY=1;
    public static final Integer BLACK=2;

    static class Graph<T> {
        private final Map<T, List<T>>
                edges;
        private final List<T> vertices;

        public Graph(List<T> vertices) {
            this.vertices = Collections.unmodifiableList(vertices);
            edges = new HashMap<>();
            vertices.forEach(vertex -> edges.putIfAbsent(vertex, new ArrayList<>()));
        }

        public void addEdge(T s, T d) {
            edges.get(s).add(d);
        }


        public List<T> topologicalSort() {
            Stack<T> stack = new Stack<>();
            Map<T, Integer> visited = new HashMap<>();
            vertices.forEach(x -> visited.putIfAbsent(x, WHITE));

            for (T vertex : vertices) {
                topologicalSortUtil(vertex, visited, stack);
            }

            return new ArrayList<>(stack);
        }

        private void topologicalSortUtil(T vertex, Map<T, Integer> visited, Stack<T> stack) {
            if (GRAY.equals(visited.get(vertex))) throw new CycleException();
            if (BLACK.equals(visited.get(vertex))) return;

            visited.put(vertex, GRAY);
            for (T adj : edges.get(vertex)) {
                topologicalSortUtil(adj, visited, stack);
            }
            visited.put(vertex, BLACK);
            stack.push(vertex);
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph<Integer> graph = readGraph(numCourses, prerequisites);
        try {
            return graph.topologicalSort().stream().mapToInt(x->x).toArray();
        } catch (CycleException e) {
            return new int[0];
        }
    }


    /**
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph<Integer> graph = readGraph(numCourses, prerequisites);
        try {
            graph.topologicalSort();
            return true;
        } catch (CycleException e) {
            return false;
        }
    }

    private Graph<Integer> readGraph(int numCourses, int[][] prerequisites) {
        List<Integer> vertices = IntStream.range(0, numCourses).boxed().collect(Collectors.toList());
        Graph<Integer> graph = new Graph<>(vertices);
        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[0], prerequisite[1]);
        }
        return graph;
    }


    public static void main(String[] args) {
        boolean strings = new TopologicalSort().canFinish(
                4,
                new int[][]{
                        {1, 0},
                        {2, 1},
                        {3, 0},
                        {2, 3}
                }
        );

        System.out.println(strings);
    }
}
