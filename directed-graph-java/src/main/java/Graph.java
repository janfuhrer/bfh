import java.util.*;

public class Graph {
    // variables
    private Map<Vertex, List<Vertex>> adjacentVertices;
    // constructor
    public Graph() {
        this.adjacentVertices = new Map<Vertex, List<Vertex>>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public List<Vertex> get(Object key) {
                return null;
            }

            @Override
            public List<Vertex> put(Vertex key, List<Vertex> value) {
                return null;
            }

            @Override
            public List<Vertex> remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends Vertex, ? extends List<Vertex>> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<Vertex> keySet() {
                return null;
            }

            @Override
            public Collection<List<Vertex>> values() {
                return null;
            }

            @Override
            public Set<Entry<Vertex, List<Vertex>>> entrySet() {
                return null;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
    }
    // getter
    public Map<Vertex, List<Vertex>> getadjacentVertices() {
        return adjacentVertices;
    }
    // setter
    public void setadjacentVertices(Map<Vertex, List<Vertex>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    // mutation operations

    // addVertex
    void addVertex(String label) {
        adjacentVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }
    // removeVertex
    void removeVertex(String label){
        Vertex v = new Vertex(label);
        // remove every link
        adjacentVertices.values().stream().forEach(e -> e.remove(v));
        adjacentVertices.remove(v);
    }
    // addEdge
    void addEdge(String label, String label2){
        Vertex vertex1 = new Vertex(label);
        Vertex vertex2 = new Vertex(label2);
        System.out.println("Test");
        adjacentVertices.get(vertex1).add(vertex2);
        System.out.println("Test2");
        adjacentVertices.get(vertex2).add(vertex1);
    }
    // removeEdge
    void removeEdge(String label, String label2){
        Vertex vertex1 = new Vertex(label);
        Vertex vertex2 = new Vertex(label2);
        List<Vertex> eV1 = adjacentVertices.get(vertex1);
        List<Vertex> eV2 = adjacentVertices.get(vertex2);
        if (eV1 != null){
            eV1.remove(vertex2);
        }
        if (eV2 != null){
            eV2.remove(vertex1);
        }
    }
}
