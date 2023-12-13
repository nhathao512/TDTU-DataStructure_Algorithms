import java.util.*;
import java.io.*;

class IntegerPair 
{
    private Integer neighbor;
    private Integer weight;

    public IntegerPair(Integer n, Integer w) 
    {
        neighbor = n;
        weight = w;
    }

    public Integer getNeighbor() 
    {
        return neighbor;
    }

    public Integer getWeight() 
    {
        return weight;
    }

    @Override
    public String toString() 
    {
        return neighbor + "," + weight;
    }
}

public class AdjacencyList 
{
    private int V; 
    private ArrayList<LinkedList<IntegerPair>> adj;

    public AdjacencyList(int v) 
    {
        V = v;
        adj = new ArrayList<LinkedList<IntegerPair>>();
        for (int i = 0; i < v; ++i)
            adj.add(new LinkedList<IntegerPair>());
    }

    public void addEdge(int u, int v, int w) 
    {
        adj.get(u).add(new IntegerPair(v, w));
    }

    public void printGraph() 
    {
        for (int i = 0; i < V; i++) 
        {
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for (IntegerPair v : adj.get(i)) 
            {
                System.out.print(" -> " + v);
            }
            System.out.println();
        }
    }

    public static AdjacencyList loadFile(String filePath) 
    {
        try 
        {
            File myFile = new File(filePath);
            Scanner sc = new Scanner(myFile);
            int vertices = Integer.valueOf(sc.nextLine());
            AdjacencyList graph = new AdjacencyList(vertices);

            while (sc.hasNextLine()) 
            {
                String row = sc.nextLine();
                String[] elementsInRow = row.split(" ");
                for (int i = 1; i < elementsInRow.length; i++) 
                {
                    String[] neighborAndWeight = elementsInRow[i].split(",");
                    graph.addEdge(Integer.valueOf(elementsInRow[0]), Integer.valueOf(neighborAndWeight[0]),
                            Integer.valueOf(neighborAndWeight[1]));
                }
            }
            sc.close();
            return graph;
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Can't load file");
            return null;
        }
    }

    public int countVertices() 
    {
        return V;
    }

    public int countEdges() 
    {
        int count = 0;
        for (int i = 0; i < V; i++) 
        {
            count += adj.get(i).size();
        }
        return count / 2; 
    }

    public void enumerateNeighborsOfVertex(int u) 
    {
        for (int i = 0; i < adj.get(u).size(); i++) 
        {
            System.out.print(adj.get(u).get(i).getNeighbor() + " ");
        }
        System.out.println();
    }

    public boolean doesEdgeExist(int u, int v) 
    {
        for (int i = 0; i < adj.get(u).size(); i++) 
        {
            if (adj.get(u).get(i).getNeighbor() == v) 
            {
                return true;
            }
        }
        return false;
    }

    public void prim(int s) 
    {

        class Edge 
        {
            private Integer weight;
            private Integer source;
            private Integer dest;

            public Edge(Integer w, Integer s, Integer d) 
            {
                weight = w;
                source = s;
                dest = d;
            }

            public Integer getDest() 
            {
                return dest;
            }

            public Integer getWeight() 
            {
                return weight;
            }

            @Override
            public String toString() 
            {
                return "(" + weight + ", " + source + "-" + dest + ")";
            }
        }

        final class CompareWeight implements Comparator<Edge> 
        {
            public int compare(Edge firstEdge, Edge secondEdge) 
            {
                if (firstEdge.getWeight() > secondEdge.getWeight()) 
                {
                    return 1;
                } 
                else if (firstEdge.getWeight() == secondEdge.getWeight()) 
                {
                    return 0;
                } 
                else 
                {
                    return -1;
                }
            }
        }

        List<Edge> mst = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(new CompareWeight());
        boolean[] visited = new boolean[V];
        
        pq.add(new Edge(0, -1, s));

        while (!pq.isEmpty()) 
        {
            Edge edge = pq.poll();
            
            if (visited[edge.getDest()])
                continue;
            visited[edge.getDest()] = true;
            
            mst.add(edge);

            for (IntegerPair e : adj.get(edge.getDest())) 
            {
                if (!visited[e.getNeighbor()]) 
                {
                    pq.add(new Edge(e.getWeight(), edge.getDest(), e.getNeighbor()));
                }
            }
        }

        mst.remove(0);

        int W = 0;
        for (Edge edge : mst) 
        {
            W += Integer.valueOf(edge.getWeight());
        }

        System.out.println(mst);
        System.out.println("W = " + W);
    }

    public static void main(String[] args)
    {
        AdjacencyList al = AdjacencyList.loadFile("AL.txt");
        al.prim(0);
    }
}