import java.util.Arrays;

class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        // Step 1: Initialize distances from the source to all vertices as infinity.
        // We use a dummy source concept or initialize all to 0 to handle disconnected graphs.
        int[] dist = new int[V];
        Arrays.fill(dist, 0); // Starting all at 0 helps detect negative cycles anywhere in disconnected components

        // Step 2: Relax all edges V - 1 times.
        for (int i = 1; i <= V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                // If a shorter path to v is found through u
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Step 3: Check for negative-weight cycles. 
        // If we can still relax any edge, then a negative weight cycle exists.
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                return true; // Negative cycle detected
            }
        }

        return false; // No negative cycle found
    }
}
