public class TaskC {
    public static void main(String[] args) {
        // create graph
        Graph graph = new Graph();

        // famous politicians
        graph.addVertex("Joe Biden");
        graph.addVertex("Alain Berset");
        graph.addVertex("Magdalena Martullo-Blocher");

        // friends
        graph.addVertex("Jan");
        graph.addVertex("Mario");
        graph.addVertex("Roger");
        graph.addVertex("Michelle");
        graph.addVertex("Anina");
        graph.addVertex("Jana");

        // links
        graph.addEdge("Jan", "Mario");
        graph.addEdge("Jan", "Michelle");
        graph.addEdge("Jan", "Roger");
        graph.addEdge("Jan", "Joe Biden");
        graph.addEdge("Jan", "Alain Berset");

        graph.addEdge("Mario", "Michelle");
        graph.addEdge("Mario", "Roger");
        graph.addEdge("Mario", "Anina");
        graph.addEdge("Mario", "Joe Biden");
        graph.addEdge("Mario", "Alain Berset");

        graph.addEdge("Roger", "Alain Berset");
        graph.addEdge("Roger", "Michelle");
        graph.addEdge("Roger", "Mario");

        graph.addEdge("Michelle", "Jan");
        graph.addEdge("Michelle", "Mario");
        graph.addEdge("Michelle", "Alain Berset");
        graph.addEdge("Michelle", "Joe Biden");

        graph.addEdge("Anina", "Jan");
        graph.addEdge("Anina", "Michelle");
        graph.addEdge("Anina", "Alain Berset");
        graph.addEdge("Anina", "Joe Biden");
        graph.addEdge("Anina", "Magdalena Martullo-Blocher");

        graph.addEdge("Jana", "Alain Berset");
        graph.addEdge("Jana", "Joe Biden");
        graph.addEdge("Jana", "Magdalena Martullo-Blocher");

        graph.addEdge("Alain Berset", "Joe Biden");
        graph.addEdge("Alain Berset", "Magdalena Martullo-Blocher");

        graph.addEdge("Magdalena Martullo-Blocher", "Joe Biden");
        graph.addEdge("Magdalena Martullo-Blocher", "Alain Berset");

        // run PageRank algorithm
        PageRank pageRank = new PageRank(graph);
        pageRank.evaluate();
        pageRank.printRank();
    }
}
