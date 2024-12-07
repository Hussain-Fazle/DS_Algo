
import java.util.*;

public class Dijkstras {

    static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // Comparable is a interface which is used to store the String, Wrapper Class
    // and Object in a particular Order
    // in a priority Queue. It is mostly used to set the priority in a
    // ProirityQueue.
    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int n, int path) {
            this.node = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // Giving the priority to the Queue (i.e order of Sorting Ascending order)
            // if you want to set the priority to descending order then (p2.path -
            // this.path)
        }
    }

    public static int[] dijkstra(ArrayList<Edge> graph[], int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // Storing the value in pair of Vertex and Distance

        int dist[] = new int[graph.length]; // Storing the Distance
        boolean vis[] = new boolean[graph.length]; // marking the vertex as True (i.e. Visited )

        for (int i = 0; i < dist.length; i++) {
            // storing the infinity value to the array except the source(i.e. '0')
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if (!vis[v] && dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        int dist[] = dijkstra(graph, src);

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }

    }
}