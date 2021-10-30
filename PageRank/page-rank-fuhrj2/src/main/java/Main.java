public class Main {
    public static void main(String[] args) {
        /*
        ------- TASK A -------
        */
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!! Task A !!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!\n");

        // create graph
        Graph graphA = new Graph();

        // create vertices
        graphA.addVertex("srf.ch");
        graphA.addVertex("bls.ch");
        graphA.addVertex("sbb.ch");
        graphA.addVertex("swisscom.ch");
        graphA.addVertex("sunrise.ch");
        graphA.addVertex("salt.ch");

        // add edges
        graphA.addEdge("srf.ch", "sbb.ch");
        graphA.addEdge("srf.ch", "bls.ch");
        graphA.addEdge("srf.ch", "swisscom.ch");
        graphA.addEdge("swisscom.ch", "srf.ch");
        graphA.addEdge("salt.ch", "sunrise.ch");
        graphA.addEdge("swisscom.ch", "bls.ch");

        // remove some vertices and edges
        graphA.removeVertex("bls.ch");
        graphA.removeEdge("salt.ch","sunrise.ch");

        // get all vertices in graph
        graphA.printVertex();

        // get all edges of a specific vertex
        System.out.println("");
        graphA.getEdges("srf.ch");

        /*
        ------- TASK B -------
        */
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!! Task B !!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!\n");

        // create graph
        Graph graphB = new Graph();

        // create vertices
        graphB.addVertex("srf.ch");
        graphB.addVertex("bls.ch");
        graphB.addVertex("sbb.ch");
        graphB.addVertex("swisscom.ch");
        graphB.addVertex("sunrise.ch");
        graphB.addVertex("salt.ch");

        // add edges
        graphB.addEdge("srf.ch", "sbb.ch");
        graphB.addEdge("srf.ch", "bls.ch");
        graphB.addEdge("swisscom.ch", "bls.ch");
        graphB.addEdge("salt.ch", "bls.ch");
        graphB.addEdge("srf.ch", "swisscom.ch");
        graphB.addEdge("bls.ch", "salt.ch");
        graphB.addEdge("swisscom.ch", "srf.ch");
        graphB.addEdge("salt.ch", "sunrise.ch");

        // run PageRank algorithm
        PageRank pageRankB = new PageRank(graphB);
        pageRankB.evaluate();
        pageRankB.printRank();

        // print single score of vertex
        System.out.println("");
        System.out.println("Score of srf.ch: " + pageRankB.getVertexScore(graphB.getVertex("srf.ch")));

        /*
        ------- TASK C -------
        */
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!! Task C !!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!\n");

        // create graph
        Graph graphC = new Graph();

        // famous politicians
        graphC.addVertex("Joe Biden");
        graphC.addVertex("Alain Berset");
        graphC.addVertex("Magdalena Martullo-Blocher");

        // friends
        graphC.addVertex("Jan");
        graphC.addVertex("Mario");
        graphC.addVertex("Roger");
        graphC.addVertex("Michelle");
        graphC.addVertex("Anina");
        graphC.addVertex("Jana");

        // links
        graphC.addEdge("Jan", "Mario");
        graphC.addEdge("Jan", "Michelle");
        graphC.addEdge("Jan", "Roger");
        graphC.addEdge("Jan", "Joe Biden");
        graphC.addEdge("Jan", "Alain Berset");

        graphC.addEdge("Mario", "Michelle");
        graphC.addEdge("Mario", "Roger");
        graphC.addEdge("Mario", "Anina");
        graphC.addEdge("Mario", "Joe Biden");
        graphC.addEdge("Mario", "Alain Berset");

        graphC.addEdge("Roger", "Alain Berset");
        graphC.addEdge("Roger", "Michelle");
        graphC.addEdge("Roger", "Mario");

        graphC.addEdge("Michelle", "Jan");
        graphC.addEdge("Michelle", "Mario");
        graphC.addEdge("Michelle", "Alain Berset");
        graphC.addEdge("Michelle", "Joe Biden");

        graphC.addEdge("Anina", "Jan");
        graphC.addEdge("Anina", "Michelle");
        graphC.addEdge("Anina", "Alain Berset");
        graphC.addEdge("Anina", "Joe Biden");
        graphC.addEdge("Anina", "Magdalena Martullo-Blocher");

        graphC.addEdge("Jana", "Alain Berset");
        graphC.addEdge("Jana", "Joe Biden");
        graphC.addEdge("Jana", "Magdalena Martullo-Blocher");

        graphC.addEdge("Alain Berset", "Joe Biden");
        graphC.addEdge("Alain Berset", "Magdalena Martullo-Blocher");

        graphC.addEdge("Magdalena Martullo-Blocher", "Joe Biden");
        graphC.addEdge("Magdalena Martullo-Blocher", "Alain Berset");

        // run PageRank algorithm
        PageRank pageRankC = new PageRank(graphC);
        pageRankC.evaluate();
        pageRankC.printRank();
    }
}
