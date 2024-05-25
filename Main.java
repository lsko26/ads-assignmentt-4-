import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(false);

//        Vertex<String> almaty = new Vertex<>("Almaty");
//        Vertex<String> astana = new Vertex<>("Astana");
//        Vertex<String> shymkent = new Vertex<>("Shymkent");
//        Vertex<String> atyrau = new Vertex<>("Atyrau");
//        Vertex<String> kostanay = new Vertex<>("Kostanay");
//        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");
//
//        graph.addVertex(almaty);
//        graph.addVertex(astana);
//        graph.addVertex(shymkent);
//        graph.addVertex(atyrau);
//        graph.addVertex(kostanay);
//        graph.addVertex(kyzylorda);
//
//        almaty.addAdjacentVertex(astana, 2.1);
//        shymkent.addAdjacentVertex(atyrau, 7.8);
//        atyrau.addAdjacentVertex(astana, 7.1);
//        almaty.addAdjacentVertex(shymkent, 7.2);
//        shymkent.addAdjacentVertex(astana, 3.9);
//        astana.addAdjacentVertex(kostanay, 3.5);
//        shymkent.addAdjacentVertex(kyzylorda, 5.4);


        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");
        Vertex<String> v5 = new Vertex<>("E");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v1, v2, 1.0);
        graph.addEdge(v1, v3, 2.0);
        graph.addEdge(v1, v4, 3.0);
        graph.addEdge(v5, v1, 5.0);
        graph.addEdge(v2, v3, 2.0);
        graph.addEdge(v3, v4, 3.0);
        graph.addEdge(v4, v5, 4.0);
        graph.addEdge(v5, v1, 5.0);

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, v1);
        outputPath(bfs, v5);

        System.out.println("--------------------------------");

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, v1);
        outputPath(dfs, v5);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, v1);
        outputPath(djk, v5);

        System.out.println(graph);
    }

    public static <V> void outputPath(Search<String> search, Vertex<V> key) {
        for (Vertex<String> v : search.pathTo((Vertex<String>) key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }

}