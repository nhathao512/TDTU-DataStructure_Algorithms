public class AVL {
    Node root;

    public int height(Node x) {
        if (x == null)
            return -1;
        return x.height;
    }

    private int checkBalance(Node x) {
        return height(x.left) - height(x.right);
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private Node balance(Node x) {
        if (checkBalance(x) < -1) {
            if (checkBalance(x.right) > 0) {
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        } else if (checkBalance(x) > 1) {
            if (checkBalance(x.left) < 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    }

    public void insert(Integer key) {
        root = insert(root, key);
    }

    private Node insert(Node x, Integer key) {
        if (x == null)
            return new Node(key);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = insert(x.left, key);
        else if (cmp > 0)
            x.right = insert(x.right, key);
        else
            x.key = key;

            x.height = Math.max(height(x.left), height(x.right)) + 1;
        return balance(x);
    }

    public Node search(Integer key) {
        return search(root, key);
    }

    private Node search(Node x, Integer key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public Node min() {
        return min(root);
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Node max() {
        return max(root);
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    public Node deleteMin() {
        return deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        // Update height after insert a key to tree
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return balance(x);
    }

    public void delete(Integer key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Integer key) {
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

            x.key = min(x.right).key;
            x.right = deleteMin(x.right);
        }

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return balance(x);
    }

    public void NLR(Node x) {
        if (x != null) {
            System.out.print(x.key + " ");
            NLR(x.left);
            NLR(x.right);
        }
    }

    public void LNR(Node x) {
        if (x != null) {
            LNR(x.left);
            System.out.print(x.key + " ");
            LNR(x.right);
        }
    }

    public void LRN(Node x) {
        if (x != null) {
            LRN(x.left);
            LRN(x.right);
            System.out.print(x.key + " ");
        }
    }

    public void printBF(Node x) {
        if (x != null) {
            printBF(x.left);
            System.out.print(checkBalance(x) + " ");
            printBF(x.right);
        }
    }
    
    public static void main(String[] args) {
        AVL tree = new AVL();

        int[] keys = {1, 4, 45, 12, 64, 18, 66, 53, 80, 10};

        for (int key : keys) {
            tree.insert(key);
        }

        tree.NLR(tree.root);
        System.out.println();
        tree.LNR(tree.root);
        System.out.println();
        tree.LRN(tree.root);
        System.out.println();
        tree.printBF(tree.root);
    }
}