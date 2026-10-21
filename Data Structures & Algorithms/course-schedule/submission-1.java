class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] preq = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int[] link : prerequisites) {
            if(preq[link[1]] == null) preq[link[1]] = new ArrayList<Integer>();
            preq[link[1]].add(link[0]);
            indegree[link[0]]++;
        }

        Queue<Integer> q = new ArrayDeque();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int cantake = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            cantake++;
            if(preq[cur] == null) continue;
            for(int next : preq[cur]){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
        return cantake >= numCourses;
    }
}
