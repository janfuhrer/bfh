public class Main {
    public static void main(String[] args){

        Graph mygraph = new Graph();
        mygraph.addVertex("srf.ch");
        mygraph.addVertex("bls.ch");
        mygraph.addVertex("sbb.ch");
        mygraph.addVertex("swisscom.ch");
        mygraph.addVertex("sunrise.ch");
        mygraph.addVertex("salt.ch");
        mygraph.addEdge("srf.ch", "sbb.ch");
        mygraph.addEdge("srf.ch", "bls.ch");
        mygraph.addEdge("srf.ch", "swisscom.ch");
        mygraph.addEdge("swisscom.ch", "srf.ch");
        mygraph.addEdge("salt.ch", "sunrise.ch");
        mygraph.addEdge("swisscom.ch", "bls.ch");
    }
}
