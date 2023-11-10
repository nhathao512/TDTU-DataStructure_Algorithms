import java.util.LinkedList;
import java.util.Queue;

public class BST 
{
    private Node root;
    private Node insert(Node x, Integer key) 
    {
        if (x == null)
            return new Node(key);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = insert(x.left, key);
        else if (cmp > 0)
            x.right = insert(x.right, key);
        else
            x.key = key;
        return x;
    }

    public void insert(Integer key)
    {
        root = insert(root, key);
    }

    public void createTree(String strKey)
    {
        String[] strK = strKey.split(" ");
        for (String string : strK)
        {
            Integer i = Integer.getInteger(string);
            insert(i);
        }
    }

    public void descending(Node x)
    {
        if (x != null)
        {
            NLR(x.right);
            System.out.print(x.key + " ");
            NLR(x.left);
        }
    }

    public void NLR(Node x) 
    {
        if (x != null) {
            System.out.print(x.key + " ");
            NLR(x.left);
            NLR(x.right);
        }
    }

    public void LNR(Node x) 
    {
        if (x != null) {
            NLR(x.left);
            System.out.print(x.key + " ");
            NLR(x.right);
        }
    }

    public void LRN(Node x) 
    {
        if (x != null) {
            NLR(x.left);             
            NLR(x.right);   
            System.out.print(x.key + " ");
        }
    }

    private Node search(Node x, Integer key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left , key);
        else if (cmp > 0)
            return search(x.right , key);
        else
            return x;
    }

    public void search(Integer key)
    {
        root = search(root, key);
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public void min()
    {
        root = min(root);
    }

    private Node max(Node x) 
    {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    public void max()
    {
        root = max(root);
    }

    private Node deleteMin(Node x) 
    {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public void deleteMin()
    {
        root = deleteMin(root);
    }

    private Node delete(Node x, Integer key) 
    {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            // node with only one child or no child
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            // node with two children: Get the successor (smallest in
            // the right subtree)
            x.key = min(x.right).key;
            x.right = deleteMin(x.right);
        }
        return x;
    }

    public void delete(Integer key)
    {
        root = delete(root, key);
    }

    private boolean contains(Node x, Integer key) {
        if (x == null)
            return false;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return contains(x.left , key);
        else if (cmp > 0)
            return contains(x.right , key);
        else
            return true;
    }

    public boolean contains(Integer key) 
    {
        return contains(root, key);
    }

    private Node deleteMax(Node x) 
    {
        if (x.right == null)
            return x.left;
        x.left = deleteMax(x.right);
        return x;
    }

    public void deleteMax() 
    {
        root = deleteMax(root);
    }

    private Node delete_pre(Node x, Integer key) 
    {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;

            x.key = max(x.left).key;
            x.left = deleteMax(x.left);
        }
        return x;
    }

    public void delete_pre(Integer key) 
    {
        root = delete_pre(root, key);
    }

    private int height(Node x)
    {
        if (x == null)
        {
            return -1;
        }
        else
        {
            return 1 + Math.max(height(x.left), height(x.right));
        }
    }

    public int height() 
    {
        return height(root);
    }

    private Integer sum(Node x)
    {
        if (x == null)
        {
            return 0;
        }
        else
        {
            return x.key + sum(x.left) + sum(x.right);
        }
    }

    public Integer sum()
    {
        return sum(root);
    }

    private Integer sumEven(Node x)
    {
        if (x == null)
        {
            return 0;
        }
        if (x.key % 2 == 0)
        {
            return x.key + sumEven(x.left) + sumEven(x.right);
        }
        return sumEven(x.left) + sumEven(x.right);
    }

    public Integer sumEven() {
        
        return sumEven(root);
    }
    
    private int countLeaves(Node x)
    {
        if (x == null)
        {
            return 0;
        }
        if (x.left == null && x.right == null)
        {
            return 1 + countLeaves(x.left) + countLeaves(x.right);
        }
        return countLeaves(x.left) + countLeaves(x.right);
    }

    public int countLeaves() {
        
        return countLeaves(root);
    }

    private int sumEvenKeysAtLeaves(Node x)
    {
    
        if (x == null)
        {
            return 0;
        }
        if ((x.left == null && x.right == null) && (x.key % 2 == 0))
        {
            return x.key + sumEvenKeysAtLeaves(x.left) + sumEvenKeysAtLeaves(x.right);
        }
        return sumEvenKeysAtLeaves(x.left) + sumEvenKeysAtLeaves(x.right);

    }

    public int sumEvenKeysAtLeaves() {
        
        return sumEvenKeysAtLeaves(root);
    }

    public void bfs() 
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node temp = queue.poll();
            System.out.print(temp.key + " ");            
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.insert(9);

        System.out.println("In-order traversal (LNR):");
        bst.LNR(bst.root);
        System.out.println();

        System.out.println("Pre-order traversal (NLR):");
        bst.NLR(bst.root);
        System.out.println();

        System.out.println("Post-order traversal (LRN):");
        bst.LRN(bst.root);
        System.out.println();

        int searchKey = 3;
        if (bst.contains(searchKey)) {
            System.out.println(searchKey + " found in the BST.");
        } else {
            System.out.println(searchKey + " not found in the BST.");
        }

        int deleteKey = 5;
        bst.delete(deleteKey);
        System.out.println("Deleted " + deleteKey + " from the BST.");

        System.out.println("Breadth-First Search (BFS):");
        bst.bfs();
        System.out.println();

        System.out.println("Height of the BST: " + bst.height());

        System.out.println("Sum of all values in the BST: " + bst.sum());

        System.out.println("Sum of even values in the BST: " + bst.sumEven());

        System.out.println("Number of leaf nodes in the BST: " + bst.countLeaves());

        System.out.println("Sum of even values at leaf nodes: " + bst.sumEvenKeysAtLeaves());
    }
}
