import java.util.ArrayList;

public class TreeNode<T extends Comparable<T>> {
    private T data;
    private int frequency;
    private int passingFrequency;
    private TreeNode<T> parent;
    private ArrayList<TreeNode<T>> children;

    TreeNode(T data, TreeNode<T> parent) {
        this.data = data;
        this.parent = parent;
        children = new ArrayList<TreeNode<T>>();
        frequency = 0;
    }

    public TreeNode<T> addChild(TreeNode<T> child) {
        for (TreeNode<T> t : children) {
            if (t.data.equals(child.data)) {
                return t;
            }
        }
        for (int i = 0; i < children.size(); i++) {
            if (child.data.compareTo(children.get(i).data) < 0) {
                children.add(i, child);
                return child;
            }
        }
        children.add(child);
        return child;
    }

    public void incrementFrequency() {
        frequency++;
    }

    public void incrementPassingFrequency() {
        passingFrequency++;
    }

    public T getData() { return data; }
    public int getFrequency() { return frequency; }
    public int getPassingFrequency() { return passingFrequency; }
    public TreeNode<T> getParent() { return parent; }
    public ArrayList<TreeNode<T>> getChildren() { return children; }
}
