public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");
        grafo.addVertex("D");
        grafo.addVertex("E");
        grafo.addVertex("F");

        grafo.addEdge(0, 1);
        grafo.addEdge(0, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(1, 4);
        grafo.addEdge(2, 5);

        grafo.displayAdjacencyMatrix();
        grafo.dfs(0);
        grafo.bfs(0);
    }
}