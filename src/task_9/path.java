
package task_9;

/**
 *
 * @author Ahmed
 */
public class path {
    void FindShortest_Path(int G[][],int source , int destination) {
         int planetsNumber=G[1].length; //initialize the number of vertics
         int []times= new int[planetsNumber]; //array of the time between planets
         Boolean []visited =new Boolean[planetsNumber] ;//array of the check if planets visited or not 
         int [] parent = new int[planetsNumber] ;//array of the parent of planets
//initialize the Graph of planets 
/*
         */
         for( int i= 0;i<planetsNumber;i++){
                    times[i]=Integer.MAX_VALUE ; //make time = infinity 
                    visited[i]=false; //make all planets not visited
                    parent[i]=-1;//make all planets parent = -1
                }
                times[source] = 0;//make time between source and itself =0 
 //_____________========_____________========___________________========
		for (int i = 0; i < planetsNumber; i++) //all planets -1
		{ 
			int min = -1; //initalize the min with -1 
			int leastTime = Integer.MAX_VALUE; // least time = infinity 
			for (int Index = 0; Index < planetsNumber;Index++) //all planets
			{ 
				if (!visited[Index] && times[Index] < leastTime) 
				{ 
					min = Index; 
					leastTime = times[Index]; //update shortest distance
				} 
			} 

			visited[min] = true; 
			for (int j = 0; j < planetsNumber; j++) //all adjecent 
			{ 
				int timeBetweenPlanets = G[min][j]; 
				
				if (timeBetweenPlanets > 0&& ((leastTime + timeBetweenPlanets) < times[j])) 
				{ 
					parent[j] = min; 
					times[j] = leastTime + timeBetweenPlanets; 
				} 
			} //end for 
		} //end big for 
              System.out.print("path is :");
              printPath(destination, parent);
              System.out.println("The time :"+times[destination]);

	} 

    	private static void printPath(int destination, int[] parents) //function print and get the shortest path
	{ 

		if (destination == -1) 
		{ 
			return; 
		} 
		printPath(parents[destination], parents); 
		System.out.print(destination+"  "); 
	} 
    }
    

