import java.util.ArrayList;

public class TreeNode {
    private String data;
    private int frequency;
    private int passingFrequency;
    private TreeNode parent;
    private ArrayList<TreeNode> children;

    TreeNode(String data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
        children = new ArrayList<TreeNode>();
        frequency = 0;
    }

    public TreeNode addChild(TreeNode child) {
        for (TreeNode t : children) {
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

    public void mergeData(TreeNode child) {
        data = data + " " + child.data;
        frequency += child.frequency;
        children = child.children;
    }

    public void incrementFrequency() {
        frequency++;
    }

    public void incrementPassingFrequency() {
        passingFrequency++;
    }

    public String getData() { return data; }
    public int getFrequency() { return frequency; }
    public int getPassingFrequency() { return passingFrequency; }
    public TreeNode getParent() { return parent; }
    public ArrayList<TreeNode> getChildren() { return children; }
}
