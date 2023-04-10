import java.util.ArrayList;

public class TreeBuilderNode {
    private ArrayList<Integer> data;
    private int frequency;
    private int passingFrequency;
    private TreeBuilderNode parent;
    private ArrayList<TreeBuilderNode> children;

    TreeBuilderNode(String s, TreeBuilderNode parent) {
        data = new ArrayList<Integer>();
        int index = Dictionary.add(s);
        data.add(index);
        this.parent = parent;
        children = new ArrayList<TreeBuilderNode>();
        frequency = 0;
    }

    public TreeBuilderNode addChild(TreeBuilderNode child) {
        for (TreeBuilderNode t : children) {
            if (t.data.equals(child.data)) {
                return t;
            }
        }
        for (int i = 0; i < children.size(); i++) {
            if (child.getData().compareTo(children.get(i).getData()) < 0) {
                children.add(i, child);
                return child;
            }
        }
        children.add(child);
        return child;
    }

    public void mergeData(TreeBuilderNode child) {
        data.addAll(child.data);
        frequency += child.frequency;
        children = child.children;
    }

    public void incrementFrequency() {
        frequency++;
    }

    public void incrementPassingFrequency() {
        passingFrequency++;
    }

    public String getData() { 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            sb.append(Dictionary.get(data.get(i)));
            if (i < data.size() - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public ArrayList<Integer> getDataArray() {  return data; }
    public int getFrequency() { return frequency; }
    public int getPassingFrequency() { return passingFrequency; }
    public TreeBuilderNode getParent() { return parent; }
    public ArrayList<TreeBuilderNode> getChildren() { return children; }
}
