import java.util.*;
import java.io.*;

class IntegerTriple implements Comparable<IntegerTriple> 
{
    private Integer weight;
    private Integer source;
    private Integer dest;

    public IntegerTriple(Integer w, Integer s, Integer d) 
    {
        weight = w;
        source = s;
        dest = d;
    }

    public Integer getWeight() 
    {
        return weight;
    }

    public Integer getSource() 
    {
        return source;
    }

    public Integer getDest() 
    {
        return dest;
    }

    @Override
    public String toString() 
    {
        return "(" + weight + ", " + source + "-" + dest + ")";
    }

    @Override
    public int compareTo(IntegerTriple that) 
    {
        return Integer.compare(this.weight, that.weight);
    }
}

public class EdgeList 
{
    private Vector<IntegerTriple> edges;

    public EdgeList() 
    {
        edges = new Vector<IntegerTriple>();
    }

    public void addEdge(int w, int u, int v) 
    {
        edges.add(new IntegerTriple(w, u, v));
    }

    public void printGraph() 
    {
        for (int i = 0; i < edges.size(); i++) 
        {
            System.out.println(edges.get(i));
        }
    }

    public static EdgeList loadFile(String filePath) 
    {
        try 
        {
            File myFile = new File(filePath);
            Scanner sc = new Scanner(myFile);
            EdgeList graph = new EdgeList();

            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String[] elementsInRow = row.split(" ");
                graph.addEdge(Integer.valueOf(elementsInRow[0]), Integer.valueOf(elementsInRow[1]),
                        Integer.valueOf(elementsInRow[2]));
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
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < edges.size(); i++) {
            set.add(edges.get(i).getSource());
            set.add(edges.get(i).getDest());
        }
        return set.size();
    }

    public int countEdges() 
    {
        return edges.size();
    }

    public void enumerateNeighborsOfVertex(int u) 
    {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getSource() == u) {
                System.out.print(edges.get(i).getDest() + " ");
            } else if (edges.get(i).getDest() == u) {
                System.out.print(edges.get(i).getSource() + " ");
            } 
        }
        System.out.println();
    }

    public boolean doesEdgeExist(int u, int v) 
    {
        for (int i = 0; i < edges.size(); i++) 
        {
            if ((edges.get(i).getSource() == u && edges.get(i).getDest() == v) || (edges.get(i).getSource() == v && edges.get(i).getDest() == u)) 
            { 
                return true;
            }
        }
        return false;
    }

    public void kruskal(int s) 
    {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(countVertices());
        List<IntegerTriple> mst = new ArrayList<>();

        for (IntegerTriple edge : edges) 
        {
            int rootOfSetContainsVertexSource = uf.findSet(edge.getSource());
            int rootOfSetContainsVertexDest = uf.findSet(edge.getDest());

            if (rootOfSetContainsVertexSource != rootOfSetContainsVertexDest)
            {
                mst.add(edge);
                uf.unionSet(rootOfSetContainsVertexSource, rootOfSetContainsVertexDest);
            }
        }

        int W = 0;
        for (IntegerTriple edge : mst)
        {
            W += Integer.valueOf(edge.getWeight());
        }

        System.out.println(mst);
        System.out.println("W = " + W);
    }

    
    public static void main(String[] args) 
    {
        EdgeList graph_EL = EdgeList.loadFile("EL.txt");
        graph_EL.kruskal(0);
    }
}