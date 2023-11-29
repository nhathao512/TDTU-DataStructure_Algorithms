import java.util.*;

public class UnionFind
{
    private Vector <Integer > p, rank , setSize;

    public UnionFind(int N) 
    {
        p = new Vector <Integer >(N);
        rank = new Vector <Integer >(N);
        setSize = new Vector <Integer >(N);
        for (int i = 0; i < N; i++) 
        {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) 
    {
        if (p.get(i) == i)
            return i;
        else 
        {
            int ret = findSet(p.get(i));
            p.set(i, ret);
            return ret;
        }
    }

    public void unionSet(int i, int j) 
    {
        if (!isSameSet(i, j)) 
        {
            int x = findSet(i), y = findSet(j);
            if (rank.get(x) > rank.get(y)) 
            {
                p.set(y, x);
                setSize.set(x, setSize.get(x) + setSize.get(y));
            }
            else
            {
                p.set(x, y);
                setSize.set(y, setSize.get(y) + setSize.get(x));
                if (rank.get(x) == rank.get(y))
                rank.set(y, rank.get(y) + 1);
            }
        }
    }

    public boolean isSameSet(int i, int j)
    {
        return findSet(i) == findSet(j);
    }
}