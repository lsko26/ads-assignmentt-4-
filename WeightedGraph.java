import java.util.*;

public class WeightedGraph<V> {
    private final Map<Vertex<V>, Vertex<V>> vertices = new HashMap<>();
    private final boolean undirected;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.putIfAbsent(vertex, vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        addVertex(source);
        addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest)) {
            return;
        }

        vertices.get(source).addAdjacentVertex(dest, weight);

        if (undirected) {
            vertices.get(dest).addAdjacentVertex(source, weight);
        }
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> dest) {
        return vertices.containsKey(source) && vertices.get(source).getAdjacentVertices().containsKey(dest);
    }

    public boolean hasVertex(Vertex<V> v) {
        return vertices.containsKey(v);
    }

    public List<Vertex<V>> adjacencyList(Vertex<V> v) {
        if (!hasVertex(v)) return null;
        return new ArrayList<>(vertices.get(v).getAdjacentVertices().keySet());
    }

    public List<Vertex<V>> getVertices() {
        return new ArrayList<>(vertices.keySet());
    }

    public Map<Vertex<V>, Double> getEdges(Vertex<V> v) {
        if (!hasVertex(v)) return null;
        return vertices.get(v).getAdjacentVertices();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Vertex<V>, Vertex<V>> entry : vertices.entrySet()) {
            Vertex<V> v = entry.getKey();
            builder.append(v.toString()).append(" -> ");
            for (Map.Entry<Vertex<V>, Double> edge : v.getAdjacentVertices().entrySet()) {
                builder.append(edge.getKey().toString()).append(" (").append(edge.getValue()).append("), ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}