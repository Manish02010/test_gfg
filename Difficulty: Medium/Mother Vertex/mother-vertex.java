import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        // Step 1: Build the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Step 2: Find the last finished vertex in DFS
        boolean[] visited = new boolean[V];
        int ans = -1;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                ans = i; // Track the last starting vertex that completes a component
            }
        }

        // Step 3: Validate if the candidate can reach all vertices
        Arrays.fill(visited, false);
        dfs(ans, adj, visited);

        // Check if any vertex was left unvisited
        for (boolean isVisited : visited) {
            if (!isVisited) {
                return -1;
            }
        }

        return ans;
    }

    private void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
}
