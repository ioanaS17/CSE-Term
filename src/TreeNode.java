public class TreeNode {
	private int[] data;
    private int frequency;
    private int passingFrequency;
    private TreeNode parent;
    private TreeNode[] children;

    TreeNode(TreeBuilderNode tbn, TreeNode parent) {
		data = new int[tbn.getDataArray().size()];
		for (int i = 0; i < data.length; i++) {
			data[i] = tbn.getDataArray().get(i);
		}
		frequency = tbn.getFrequency();
		passingFrequency = tbn.getPassingFrequency();
		this.parent = parent;
        children = new TreeNode[tbn.getChildren().size()];
        for (int i = 0; i < children.length; i++) {
            children[i] = new TreeNode(tbn.getChildren().get(i), this);
        }
    }

    public String getData() { 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(Dictionary.get(data[i]));
            if (i < data.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
    public int getFrequency() { return frequency; }
    public int getPassingFrequency() { return passingFrequency; }
    public TreeNode getParent() { return parent; }
    public TreeNode[] getChildren() { return children; }
}
