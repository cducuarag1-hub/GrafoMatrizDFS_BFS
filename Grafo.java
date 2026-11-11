import java.util.ArrayDeque;
import java.util.Queue;

public class Grafo {
    private final String[] vertexList;
    private final int[][] adjMat;
    private final boolean[] visited;
    private int nVerts;

    public Grafo(int maxVertices) {
        if (maxVertices <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }

        vertexList = new String[maxVertices];
        adjMat = new int[maxVertices][maxVertices];
        visited = new boolean[maxVertices];
    }

    public void addVertex(String label) {
        if (label == null || label.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del vertice no puede estar vacio.");
        }
        if (nVerts == vertexList.length) {
            throw new IllegalStateException("El grafo alcanzo su capacidad maxima.");
        }

        vertexList[nVerts++] = label;
    }

    public void addEdge(int start, int end) {
        validateVertex(start);
        validateVertex(end);

        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void dfs(int start) {
        validateVertex(start);
        resetVisited();

        System.out.print("DFS: ");
        dfsVisit(start);
        System.out.println();
    }

    private void dfsVisit(int vertex) {
        visited[vertex] = true;
        displayVertex(vertex);

        for (int neighbor = 0; neighbor < nVerts; neighbor++) {
            boolean hasEdge = adjMat[vertex][neighbor] == 1;
            boolean notVisited = !visited[neighbor];

            if (hasEdge && notVisited) {
                dfsVisit(neighbor);
            }
        }
    }

    public void bfs(int start) {
        validateVertex(start);
        resetVisited();

        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int current = queue.remove();
            displayVertex(current);

            for (int neighbor = 0; neighbor < nVerts; neighbor++) {
                boolean hasEdge = adjMat[current][neighbor] == 1;
                boolean notVisited = !visited[neighbor];

                if (hasEdge && notVisited) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void displayAdjacencyMatrix() {
        System.out.println("Matriz de adyacencia:");
        System.out.print("    ");
        for (int i = 0; i < nVerts; i++) {
            System.out.printf("%4s", vertexList[i]);
        }
        System.out.println();

        for (int row = 0; row < nVerts; row++) {
            System.out.printf("%4s", vertexList[row]);
            for (int column = 0; column < nVerts; column++) {
                System.out.printf("%4d", adjMat[row][column]);
            }
            System.out.println();
        }
    }

    private void displayVertex(int vertex) {
        System.out.print(vertexList[vertex] + " ");
    }

    private void resetVisited() {
        for (int i = 0; i < nVerts; i++) {
            visited[i] = false;
        }
    }

    private void validateVertex(int vertex) {
        if (vertex < 0 || vertex >= nVerts) {
            throw new IndexOutOfBoundsException("Indice de vertice invalido: " + vertex);
        }
    }
}
