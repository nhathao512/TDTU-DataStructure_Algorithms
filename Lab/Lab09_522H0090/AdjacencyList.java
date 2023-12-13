import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AdjacencyList 
{
    private int V; 
    private LinkedList <Integer > adj[];

    @SuppressWarnings("unchecked")
    public AdjacencyList(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
        adj[i] = new LinkedList <Integer >();
    }

    public void addEdge(int u, int v)
    {
        adj[u].add(v);
    }

    public void printGraph()
    {
        for(int i = 0; i < V; i++)
        {
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for(Integer v: adj[i])
            {
                System.out.print("->" + v);
            }
            System.out.println();
        }
    }
    
    public AdjacencyList(String path) 
    {
        String filePath = path;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            V = Integer.parseInt(br.readLine().trim());
            adj = new LinkedList[V];
            for (int i = 0; i < V; ++i)
                adj[i] = new LinkedList<Integer>();
            while ((line = br.readLine()) != null) {
                String[] s = line.split("\\s+");
                int vertex = Integer.parseInt(s[0]);
                for (int i = 1; i < s.length; i++) {
                    addEdge(vertex, Integer.parseInt(s[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfVertices() {
        return V;
    }

    public int getNumberOfEdges() {
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (Integer v : adj[i]) {
                count++;
            }
        }
        return count / 2;
    }

    public void enumerate(int v) {
        System.out.print("Enumerate neighbors of vertex " + v + " : ");
        for (int i = 0; i < V; i++) {
            if (i == v) {
                for (Integer v1 : adj[i]) {
                    System.out.print(v1 + " ");
                }
            }
        }
        System.out.println();
    }

    public boolean checkExis(int v, int u) {
        for (int i = 0; i < V; i++) {
            if (i == v) {
                for (Integer v1 : adj[i]) {
                    if (v1 == u)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        AdjacencyList graph = new AdjacencyList("Exercise2.txt");
        System.out.println("AL : ");
        graph.printGraph();
        // b
        System.out.println("The number of vertices : " + graph.getNumberOfVertices());
        // c
        System.out.println("The number of edges : " + graph.getNumberOfEdges());
        // d
        graph.enumerate(2);
        // e
        System.out.println("Check the existence of edge (2, 4) : " + graph.checkExis(2, 4));
        System.out.println("Check the existence of edge (2, 6) : " + graph.checkExis(2, 6));
    }
}
