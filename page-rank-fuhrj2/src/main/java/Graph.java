import java.util.*;

public class Graph {
    // variables
    private Map<String, Vertex> vertexMap;
    // constructor
    public Graph() {
        this.vertexMap = new HashMap<>();
    }
    // addVertex method
    public void addVertex(String label) {
        Vertex v = new Vertex(label);
        vertexMap.put(label,v);
    }
    // removeVertex method
    public void removeVertex(String label) {
        Vertex v = vertexMap.get(label);
        // remove all links to or from this vertex from the graph
        v.getOutEdges().forEach(e -> e.removeInEdge(v));
        v.getInEdges().forEach(e -> e.removeOutEdge(v));
        vertexMap.remove(label);
    }
    // isEmpty method
    public boolean isEmpty() {
        return this.vertexMap.isEmpty();
    }
    // addEdge method
    public void addEdge(String startLabel, String endLabel) throws IllegalArgumentException {
        if (vertexMap.containsKey(startLabel) && vertexMap.containsKey(endLabel)) {
            Vertex startVertex = vertexMap.get(startLabel);
            Vertex endVertex = vertexMap.get(endLabel);

            // add outEdge and inEdge to the vertex
            startVertex.addOutEdge(endVertex);
            endVertex.addInEdge(startVertex);
        } else {
            throw new IllegalArgumentException("failed to add edge from " + startLabel + " to " + endLabel);
        }
    }
    // removeEdge method
    public void removeEdge(String startLabel, String endLabel) throws IllegalArgumentException {
        if (vertexMap.containsKey(startLabel) && vertexMap.containsKey(endLabel)) {
            Vertex startVertex = vertexMap.get(startLabel);
            Vertex endVertex = vertexMap.get(endLabel);
            if (startVertex.getOutEdges() != null) {
                startVertex.removeOutEdge(endVertex);
            }
            if (endVertex.getInEdges() != null) {
                endVertex.removeInEdge(startVertex);
            }
        } else {
            throw new IllegalArgumentException("failed to remove edge from " + startLabel + " to " + endLabel);
        }
    }
    // getEdges method
    public void getEdges(String label) {
        Vertex v = vertexMap.get(label);

        System.out.println("-------------------------");
        System.out.println("incoming edges for vertex " + v.getLabel());
        System.out.println("-------------------------");
        v.getInEdges().forEach(System.out::println);

        System.out.println("\n-------------------------");
        System.out.println("outgoing edges for vertex " + v.getLabel());
        System.out.println("-------------------------");
        v.getOutEdges().forEach(System.out::println);
    }
    // printVertex method
    public void printVertex() {
        System.out.println("-------------------------");
        System.out.println("all vertices in graph ");
        System.out.println("-------------------------");
        // print all vertex (label)
        vertexMap.keySet().forEach(System.out::println);
    }
    // size method
    public int size() {
        return vertexMap.entrySet().size();
    }
    // getVertices method
    public  Collection<Vertex> getVertices() {
        return this.vertexMap.values();
    }
    // getVertex method
    public Vertex getVertex(String label) {
        return vertexMap.get(label);
    }
}