class Solution {
    public int findCircleNum(int[][] isConnected) {
        // isConnected[i][j] = 1; // Connection b/w i and j city
        // isConnected[i][j] = 0; // No connection

        int numberOfCities = isConnected.length;
        boolean[] visited = new boolean[numberOfCities]; // All False initially
        int count = 0;
        for(int i = 0; i < numberOfCities; i++){
            if(!visited[i]){ // if city not visited
                dfs(i, isConnected, visited);
                // BackTrack
                count++;
            }
        }
        return count;
    }
    void dfs(int currentCity, int[][] isConnected, boolean[] visited){
        visited[currentCity] = true;
        // current city's neighbour city
        for(int neighbour = 0; neighbour < isConnected.length; neighbour++){
            if(isConnected[currentCity][neighbour] == 1 && !visited[neighbour]){
                dfs(neighbour, isConnected, visited);
            }       
        }

    }
}