public class TaskB {
    public static void main(String[] args){
        // create graph
        Graph graph = new Graph();

        // create vertex
        graph.addVertex("srf.ch");
        graph.addVertex("bls.ch");
        graph.addVertex("sbb.ch");
        graph.addVertex("swisscom.ch");
        graph.addVertex("sunrise.ch");
        graph.addVertex("salt.ch");

        // add edges
        graph.addEdge("srf.ch", "sbb.ch");
        graph.addEdge("srf.ch", "bls.ch");
        graph.addEdge("srf.ch", "swisscom.ch");
        graph.addEdge("swisscom.ch", "srf.ch");
        graph.addEdge("salt.ch", "sunrise.ch");
        graph.addEdge("swisscom.ch", "bls.ch");

        // run
        PageRank pageRank = new PageRank(graph);
        pageRank.evaluate();
        pageRank.printRank();
    }
}
