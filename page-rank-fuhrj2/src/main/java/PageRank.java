import java.util.Map;

public class PageRank {
    private final Graph graph;
    private final double tolerance = 0.0001;
    private final double dampingFactor = 0.85d;
    private final int maxIterations = 100;
    private Map<Vertex, Double> scores;

    // constructor
    public PageRank(Graph graph){
        this.graph = graph;
    }

    // get map with the scores of all vertices
    public Map<Vertex, Double> getScores(){
        return scores;
    }

    // get vertex score
    public Double getVertexScore(Vertex v){
        return getScores().get(v);
    }

    // algorithm
    public void evaluate(){
        int totalVertices = graph.size();

        double dumpTerm = (1 - dampingFactor) / totalVertices;

        for (Vertex v : graph.getMap().values()){
            for (int j = 0; j < v.getInEdges().size(); j++){
                //...
            }
        }
    }

    // print
    public void printRank(){

    }
}
