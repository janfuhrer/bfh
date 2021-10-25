public class TaskA {
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

        // remove some vertex and edges
        graph.removeVertex("bls.ch");
        graph.removeEdge("salt.ch","sunrise.ch");

        // get some edges
        graph.getEdges("srf.ch");

        // get all vertex
        System.out.println("");
        graph.getVertex();
    }
}