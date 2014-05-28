package Dijkstra.Test.Algorithm.Erik;

public class ShortestMapDS {

	protected int map[][] = null;
	protected int INF = 99999999; //if two vertex has no connect, consider the distance between is infinity
	
	private int testmap[][] = {
			{0,3,4,INF,INF,INF},
			{3,0,INF,7,8,INF},
			{4,INF,0,4,8,INF},
			{INF,7,4,0,INF,6},
			{INF,8,8,INF,0,1},
			{INF,INF,INF,6,1,0}
	};
	
	public ShortestMapDS() {
		// TODO Auto-generated constructor stub
		this.map = testmap;
	}
	
	protected int getNumberOfVetex(){
		return map.length;
	}
	
	protected int getShortestPath(int start, int end){
		if (start == end){
			return 0;
		}else{
			int trace[] = new int[map.length]; //pre-ancestor of the vertex
			int visited[] = new int[map.length];
			int distance[] = new int[map.length];
			distance[start] = 0;
			for (int t = 0 ; t< map.length;t++){
				visited[t] = 0;
				distance[t] = map[start][t];
				trace[t] = 0; // make anscestor to 0
				//System.out.println(distance[t]);
			}
			

			visited[start] = 1;
			int k = start;
			
			for(int i=1;i<map.length;i++){
				int min = INF;
				for(int j = 0; j < map.length;j++){
					if (visited[j] == 0 && distance[j] < min){
						min = distance[j];
						//System.out.println(min);
						k = j;
					}
				}
				visited[k] = 1;
				//System.out.println("Vertex "+k+" was visited");
				
				for(int j = 0; j < map.length; j++){
					if(visited[j] == 0 && (distance[j] > distance[k] + map[k][j])){
						distance[j] = map[k][j] + distance[k];
						trace[j] = k;
					}else{
						
					}
				}	
			}
			/*for (int each : trace){
				System.out.println(each);	
			}*/
			
			int oriend = end;
			String strTrace =  ""+end;
			while(trace[end] != 0){
				strTrace =  trace[end] + " -> "+strTrace;
				end = trace[end];
			}
			strTrace = start + " -> " + strTrace;
			System.out.println(strTrace);
			
			return distance[oriend];
		}
	}
}
