import java.util.*;

public class PageRank {
    // variables
    private final Graph graph;
    private final double terminationDelta = 0.0001;
    private final double dampingFactor = 0.85d;
    private final int maxIterations = 100;
    private Map<Vertex, Double> scores;
    private double diff;

    // constructor
    public PageRank(Graph graph){
        this.graph = graph;
        this.scores = new HashMap<>();
    }

    // getVertexScore method
    public Double getVertexScore(Vertex vertex){
        return scores.get(vertex);
    }

    // entrypoint algorithm
    // evaluate method
    public void evaluate() throws UnsupportedOperationException {
        if (graph.isEmpty()) {
            System.out.println("!! No vertex in graph !!");
            throw new UnsupportedOperationException();
        }

        int totalVertices = graph.size();

        System.out.println("------------------------");
        System.out.println("-- Calculate PageRank --");
        System.out.println("terminationDelta: " + terminationDelta);
        System.out.println("totalVertices: " + totalVertices);
        System.out.println("maxIterations: " + maxIterations);

        //initialize PageRank for all vertices
        double initRank = 1.0 / totalVertices;
        for (Vertex v : graph.getVertices()) {
            scores.put(v, initRank);
        }

        // run algorithm until maxIterations or terminationDelta is reached
        int iterationCount = 0;
        do {
            if (iterationCount < maxIterations){
                iteration();
                iterationCount++;
            } else {
                System.out.println("!! max. iterations reached !!");
                // exit while
                diff = terminationDelta;
            }
        } while (diff > terminationDelta);
        System.out.println("iterationCount: " + iterationCount);
        System.out.println("------------------------\n");
    }

    // iteration method
    private void iteration() {
        int totalVertices = graph.size();
        // calculate the dampingTerm
        double dampingTerm = (1 - dampingFactor) / totalVertices;
        // create a temporary map for the new calculated ranks of this iteration
        Map<Vertex, Double> newRanks = new HashMap<>();
        double nonOutgoingEdges = 0;

        for (Vertex v : graph.getVertices()){
            double sum = 0;
            for (Vertex inEdge : v.getInEdges()) {
                sum += scores.get(inEdge) / inEdge.getOutEdges().size();
            }
            // save the new calculated rank
            newRanks.put(v,dampingTerm + dampingFactor * sum);
            // add rank of vertex the nonOutgoingEdges variable, if there are no outgoing edges
            if (v.getOutEdges().size() == 0) {
                nonOutgoingEdges += scores.get(v);
            }
        }

        // calculate the nonOutgoingEdges var
        nonOutgoingEdges *= dampingFactor / totalVertices;

        diff = 0;
        for (Vertex v : graph.getVertices()) {
            double currentRank = scores.get(v);
            // calculate the final rank with the nonOutgoingEdges var
            double newRank = newRanks.get(v) + nonOutgoingEdges;
            // calculate the new diff
            diff += Math.abs(newRank - currentRank);
            // save the new score
            scores.put(v, newRank);
        }
    }

    // printRank method
    public void printRank() throws UnsupportedOperationException{
        System.out.println("----------------------");
        System.out.println("-- Display PageRank --");
        if (graph.isEmpty()) {
            System.out.println("!! no vertex in graph !!");
            throw new UnsupportedOperationException();
        }
        else if (scores.isEmpty()) {
            System.out.println("!! PageRank not yet calculated !!");
            throw new UnsupportedOperationException();
        } else {
            // print every vertex with associated PageRank
            for (var entry : scores.entrySet()) {
                System.out.println(entry.getKey().toString() + ": " + entry.getValue());
            }
        }
        System.out.println("----------------------");
    }
}
