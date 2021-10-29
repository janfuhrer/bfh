import java.util.*;

public class Vertex {
    // variables
    private String label;
    private List<Vertex> inEdges;
    private List<Vertex> outEdges;

    // constructor
    Vertex(String label) {
        this.label = label;
        if (this.inEdges == null){
            this.inEdges = new ArrayList<>();
        }
        if (this.outEdges == null){
            this.outEdges = new ArrayList<>();
        }
    }

    // getter
    public List<Vertex> getInEdges() {
        return this.inEdges;
    }

    public List<Vertex> getOutEdges() {
        return this.outEdges;
    }

    public String getLabel() {
        return this.label;
    }

    // methods
    public void addInEdge (Vertex vertex) {
        this.inEdges.add(vertex);
    }

    public void addOutEdge (Vertex vertex) {
        this.outEdges.add(vertex);
    }

    public void removeInEdge (Vertex vertex) {
        this.inEdges.remove(vertex);
    }

    public void removeOutEdge (Vertex vertex) {
        this.outEdges.remove(vertex);
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return this.label.equals(vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
