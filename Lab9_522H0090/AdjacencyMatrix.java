import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class AdjacencyMatrix
{
    private int[][] adj;
    private final int NUMBER_OF_VERTICES;

    public AdjacencyMatrix(int vertices)
    {
        NUMBER_OF_VERTICES = vertices;
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
    }

    public void setEgde(int vertexSource , int vertexDestination ,int weight)
    {
        try 
        {
            adj[vertexSource][vertexDestination] = weight;
            adj[vertexDestination][vertexSource] = weight;
        } 
        catch (ArrayIndexOutOfBoundsException indexBounce)
        {
            System.out.println("The vertex is invalid");
        }
    }

    public int getEgde(int vertexSource , int vertexDestination)
    {
        try
        {
        
            return adj[vertexSource][vertexDestination];
        } 
        catch (ArrayIndexOutOfBoundsException indexBounce)
        {
        
            System.out.println("The vertex is invalid");
        }
        return -1;
    }

    public void printGraph()
    {
        for(int i = 0; i < NUMBER_OF_VERTICES; i++)
        {
            for(int j = 0;j < NUMBER_OF_VERTICES; j++)
            {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int s){
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        
        Queue <Integer > queue = new LinkedList <Integer >();
      
        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty())
        {
            int x = queue.poll();
            System.out.print(x + " ");

            for(int i = 0; i < NUMBER_OF_VERTICES; i++)
            {
                if(adj[x][i] != 0 && visited[i] == false)
                {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void DFS_recur(int v, boolean[] visited)
    {
        visited[v] = true;
 
        System.out.print(v + " ");
   
        for(int i = 0; i < NUMBER_OF_VERTICES; i++)
        {
            if(adj[v][i] != 0 && visited[i] == false)
            {
                DFS_recur(i, visited);
            }
        }
    }
        
    public void DFS(int s)
    {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        DFS_recur(s, visited);
    }

    public int getNumberOfVertices()
    {
        return NUMBER_OF_VERTICES;
    }

    public int getNumberOfEdges()
    {
        int count = 0;
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                if (adj[i][j] != 0) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    public List<Integer> getNeighbors(int vertex) 
    {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if (adj[vertex][i] != 0) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public boolean hasEdge(int u, int v) {
        try {
            return adj[u][v] != 0;
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("Invalid vertices");
            return false;
        }
    }

    public AdjacencyMatrix(String filename) throws Exception 
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        NUMBER_OF_VERTICES = sc.nextInt();
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
        sc.nextLine();
        for (int i = 0; i < NUMBER_OF_VERTICES; i++)
        {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++)
            {
                adj[i][j] = sc.nextInt();
            }
        }
    }

    public void StackDFS(int startV) 
    {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Stack<Integer> stack = new Stack<>();
        stack.push(startV);
        while (!stack.isEmpty()) 
        {
            int currV = stack.pop();
            if (!visited[currV]) {
                System.out.print(currV + " ");
                visited[currV] = true;
            }

            for (int i = NUMBER_OF_VERTICES - 1; i >= 0; i--) 
            {
                if (adj[currV][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public boolean isReachable(int u, int v) 
    {
        if (adj[u][v] == 1)
            return true;
        return false;
    }

    public AdjacencyList convertToAL() 
    {
        AdjacencyList adjacencyList = new AdjacencyList(NUMBER_OF_VERTICES);
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) 
        {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) 
            {
                if (adj[i][j] == 1) 
                {
                    adjacencyList.addEdge(i, j);
                }
            }
        }
        return adjacencyList;
    }

    public static void main(String args[]) throws Exception 
    {
        AdjacencyMatrix AdjMatrix = new AdjacencyMatrix("Exercise1.txt");
        System.out.println("AM : ");
        AdjMatrix.printGraph();
        // b
        System.out.println("The number of vertices = " + AdjMatrix.getNumberOfVertices());
        // c
        System.out.println("The number of edges = " + AdjMatrix.getNumberOfEdges());
        // d
        System.out.print("Enumerate neighbors of a vertex u : " + AdjMatrix.getNeighbors(1));
        // d
        System.out.println("\nThe existence of edge  " + AdjMatrix.hasEdge(2, 2));
        System.out.println("The existence of edge  " + AdjMatrix.hasEdge(2, 3));
        // Exercise 4a - BFS
        System.out.print("BFS : ");
        AdjMatrix.BFS(3);
        // Exercise 4b - DFS
        System.out.print("DFS : ");
        AdjMatrix.DFS(0);
        // Exercise 4c - Stack DFS
        System.out.print("DFS using Stack : ");
        AdjMatrix.StackDFS(0);
        // Exercise 4d - IsReachable
        System.out.println("vertex 4 is reachable from vertex 0 : " + AdjMatrix.isReachable(4, 0));
        System.out.println("vertex 4 is reachable from vertex 2 : " + AdjMatrix.isReachable(4, 2));
        //Exercise 5 - Convert AdjacencyMatrix to Adjacency List
        System.out.println("After convert to Adjacency List");
        AdjMatrix.convertToAL().printGraph();
    }
}