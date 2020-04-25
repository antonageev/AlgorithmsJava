package lesson7;

import java.util.LinkedList;

public class BreadthFirstPath {
    private int[] edgeTo;
    private boolean[] marked;
    private int[] distTo;
    private int source;

    private final int INFINITY = Integer.MAX_VALUE;

    public BreadthFirstPath(Graph graph, int source) {
        this.marked = new boolean[graph.getVertexCount()];
        this.edgeTo = new int[graph.getVertexCount()];
        this.distTo = new int[graph.getVertexCount()];
        this.source = source;

        for (int i = 0; i < distTo.length; i++){
            distTo[i] = INFINITY;
        }

        bfs(graph, source);
    }

    private void bfs(Graph graph, int source){
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast(source);
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()){
            int vertex = queue.removeFirst();
            for (int w: graph.getAdjList(vertex)){
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    distTo[w] = distTo[vertex] + 1;
                    queue.addLast(w);
                }

            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;

        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;

        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
