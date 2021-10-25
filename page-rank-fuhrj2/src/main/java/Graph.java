import java.util.*;

public class Graph {
    // variables
    private Map<String, Vertex> vertexMap;
    // constructor
    public Graph() {
        this.vertexMap = new HashMap<>();
    }
    // addVertex
    void addVertex(String label) {
        Vertex v = new Vertex(label);
        vertexMap.put(label,v);
    }
    // removeVertex
    void removeVertex(String label){
        Vertex v = vertexMap.get(label);
        // remove all links to or from this vertex from the graph
        v.getOutEdges().forEach(e -> e.removeInEdge(v));
        v.getInEdges().forEach(e -> e.removeOutEdge(v));
        vertexMap.remove(label);
    }
    // addEdge
    void addEdge(String startLabel, String endLabel){
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
    // removeEdge
    void removeEdge(String startLabel, String endLabel){
        if (vertexMap.containsKey(startLabel) && vertexMap.containsKey(endLabel)) {
            Vertex startVertex = vertexMap.get(startLabel);
            Vertex endVertex = vertexMap.get(endLabel);
            if (startVertex.getOutEdges() != null){
                startVertex.removeOutEdge(endVertex);
            }
            if (endVertex.getInEdges() != null){
                endVertex.removeInEdge(startVertex);
            }
        } else {
            throw new IllegalArgumentException("failed to remove edge from " + startLabel + " to " + endLabel);
        }
    }
    // getEdges
    void getEdges(String label){
        Vertex v = vertexMap.get(label);

        System.out.println("-------------------------");
        System.out.println("Ingoing Edges for vertex " + v.getLabel());
        System.out.println("-------------------------");
        for (Vertex s : v.getInEdges()){
            System.out.println(s.getLabel());
        }

        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("Outgoing Edges for vertex " + v.getLabel());
        System.out.println("-------------------------");
        for (Vertex s : v.getOutEdges()){
            System.out.println(s.getLabel());
        }
    }
    // getVertex
    void getVertex(){
        System.out.println("-------------------------");
        System.out.println("All vertex in map ");
        System.out.println("-------------------------");
        for (var entry : vertexMap.entrySet()) {
            System.out.println(entry.getValue().getLabel());
        }
    }
}
