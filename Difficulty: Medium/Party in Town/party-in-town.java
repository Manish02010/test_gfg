import java.util.*;

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1) return 0;

        // Step 1: Find the farthest node from house 1 (0-indexed as index 0)
        int[] firstBfs = bfs(0, adj, n);
        int farthestNode = firstBfs[0];

        // Step 2: Find the diameter of the tree starting from that farthest node
        int[] secondBfs = bfs(farthestNode, adj, n);
        int diameter = secondBfs[1];

        // The minimum possible maximum distance is ceil(diameter / 2.0)
        return (diameter + 1) / 2;
    }

    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            // neighbors in adj are 1-indexed, convert to 0-indexed for internal logic
            for (int neighbor : adj.get(u)) {
                int v = neighbor - 1;
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                    if (dist[v] > maxDist) {
                        maxDist = dist[v];
                        farthestNode = v;
                    }
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }
}
