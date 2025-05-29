import java.io.*;
import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }
    public Color getColor() {
        return color;
    }
    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    public ArrayList<Tree> getChildren() {
        return children;
    }

    @Override
    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    @Override
    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    @Override
    public int getResult() {
        return sum;
    }

    @Override
    public void visitNode(TreeNode node) {
        // Do nothing for non-leaf nodes
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private final int MOD = 1000000007;

    @Override
    public int getResult() {
        return (int) product;
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int sumEvenDepthNonLeaf = 0;
    private int sumGreenLeaf = 0;

    @Override
    public int getResult() {
        return Math.abs(sumEvenDepthNonLeaf - sumGreenLeaf);
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumEvenDepthNonLeaf += node.getValue();
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumGreenLeaf += leaf.getValue();
        }
    }
}

public class JavaVisitorPattern {
    private static Map<Integer, List<Integer>> edges = new HashMap<>();
    private static int[] values;
    private static Color[] colors;

    public static Tree solve() {
        int n = values.length;
        return buildTree(1, 0, new boolean[n + 1]);
    }

    private static Tree buildTree(int nodeId, int depth, boolean[] visited) {
        visited[nodeId] = true;
        List<Integer> childrenList = edges.getOrDefault(nodeId, new ArrayList<>());

        if (childrenList.size() == 0) {
            // leaf node
            return new TreeLeaf(values[nodeId - 1], colors[nodeId - 1], depth);
        } else {
            TreeNode node = new TreeNode(values[nodeId - 1], colors[nodeId - 1], depth);
            for (int childId : childrenList) {
                if (!visited[childId]) {
                    node.addChild(buildTree(childId, depth + 1, visited));
                }
            }
            return node;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        values = new int[n];
        String[] vals = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(vals[i]);
        }

        colors = new Color[n];
        String[] cols = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            colors[i] = cols[i].equals("0") ? Color.RED : Color.GREEN;
        }

        // Read edges
        for (int i = 0; i < n - 1; i++) {
            String[] edgeParts = br.readLine().trim().split(" ");
            int u = Integer.parseInt(edgeParts[0]);
            int v = Integer.parseInt(edgeParts[1]);

            edges.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            edges.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Tree root = solve();

        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        System.out.println(vis1.getResult());
        System.out.println(vis2.getResult());
        System.out.println(vis3.getResult());
    }
}
