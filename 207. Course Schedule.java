class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // step 1 matrix - convert into adjaceny list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //adding vertex
        for(int i =0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        // adding edges
        for(int [] edge : prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];
            graph.get(prerequisite).add(course); // u --> v directed
            
        }   

        //step 2= indegree array
        int [] indegree = new int[numCourses];
        for(int u = 0; u<numCourses; u++){
            for(int v : graph.get(u)){
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i); //add these vertices which has 0 indegree
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int neighbour : graph.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }
        
        return count == numCourses ? true : false;
        
    }
}