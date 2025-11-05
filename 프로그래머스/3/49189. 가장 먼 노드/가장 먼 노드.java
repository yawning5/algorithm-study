import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        visited[1] = true;
        dist[1] = 0;
        q.offer(1);
        
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i]  = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            int a = e[0], b = e[1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int maxDist = 0;
        for (int i = 1; i<= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) answer++;
        }
        
        return answer;
    }
}