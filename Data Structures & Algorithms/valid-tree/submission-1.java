class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();

        if (!dfs(0, -1, adj, visit)) {
            return false;
        }

        return visit.size() == n;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> visit) {
        if (visit.contains(node)) {
            return false;
        }

        visit.add(node);
        
        for (int neighbour : adj.get(node)) {
            if (neighbour == parent) {
                continue;
            }
            if (!dfs(neighbour, node, adj, visit)) {
                return false;
            }
        }

        return true;
    }
}
