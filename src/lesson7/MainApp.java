package lesson7;

public class MainApp {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(1,6);
        graph.addEdge(1,4);
        graph.addEdge(6,8);
        graph.addEdge(8,2);
        graph.addEdge(6,7);
        graph.addEdge(7,9);
        graph.addEdge(4,0);
        graph.addEdge(3,5);

        System.out.println(graph.getAdjList(6));

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.hasPathTo(6));
        System.out.println(bfp.hasPathTo(3));
        System.out.println(bfp.pathTo(9));
        System.out.println(bfp.pathTo(2));

        // еще один граф
        System.out.println("Еще один граф для проверки");
        Graph graph1 = new Graph(10);
        graph1.addEdge(0,1);
        graph1.addEdge(0,3);
        graph1.addEdge(0,2);
        graph1.addEdge(1,4);
        graph1.addEdge(4,5);
        graph1.addEdge(3,6);
        graph1.addEdge(2,7);
        graph1.addEdge(7,8);
        graph1.addEdge(8,6);
        BreadthFirstPath bfp1 = new BreadthFirstPath(graph1, 0);
        System.out.println(bfp1.pathTo(6));

    }
}
