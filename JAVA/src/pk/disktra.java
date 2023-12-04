package pk;
import java.util.*;

public class disktra {
    private static class Vertex implements Comparable<Vertex> {
        int id;
        int distance;

        public Vertex(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(int[][] graph, int source) {
        int numVertices = graph.length;
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.offer(new Vertex(source, 0));

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.distance > distances[current.id]) {
                continue;
            }

            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                if (graph[current.id][neighbor] > 0) {
                    int newDistance = current.distance + graph[current.id][neighbor];

                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        queue.offer(new Vertex(neighbor, newDistance));
                    }
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 4, 0, 0, 0},
            {2, 0, 1, 7, 0, 0},
            {4, 1, 0, 0, 3, 0},
            {0, 7, 0, 0, 1, 2},
            {0, 0, 3, 1, 0, 5},
            {0, 0, 0, 2, 5, 0}
        };
        
     
        

        int source = 0;
        int[] distances = dijkstra(graph, source);

        for (int i = 0; i < distances.length; i++) {
            System.out.println("Distance de " + source + " à " + i + " : " + distances[i]);
        }
    }
}

