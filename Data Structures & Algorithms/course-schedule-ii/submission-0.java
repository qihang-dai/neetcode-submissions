class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] child = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];

        for(int[] link : prerequisites) {
            if(child[link[1]] == null) child[link[1]] = new ArrayList<Integer>();
            child[link[1]].add(link[0]);
            indegree[link[0]]++;
        }

        Queue<Integer> q = new ArrayDeque();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int index = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            res[index++] = cur;
            if(child[cur] == null) continue;
            for(int next : child[cur]){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
        return index == numCourses ? res : new int[]{};
    }
}
