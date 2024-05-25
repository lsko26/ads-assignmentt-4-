public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);

        dfs(graph, source);
    }

    private void dfs(WeightedGraph<V> graph, Vertex<V> current) {
        marked.add(current);

        for (Vertex<V> v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}