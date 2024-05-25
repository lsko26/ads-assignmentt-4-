import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();
    public Vertex(V data) {
        this.data = data;
    }
    public V getData() {
        return data;
    }
    public void setData(V data) {
        this.data = data;
    }
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    @Override
    public String toString() {
        return  data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }
}