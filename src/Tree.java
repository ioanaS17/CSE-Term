import java.util.ArrayList;

public class Tree<T extends Comparable<T>> {

    TreeNode<T> root;

    Tree() {
        root = new TreeNode<T>(null, null);
    }

    public TreeNode<T> addNode(T data, TreeNode<T> parent) {
        if (parent == null) parent = root;
        TreeNode<T> newNode = new TreeNode<T>(data, parent);
        newNode = parent.addChild(newNode);
        return newNode;
    }

    public void compress() {
        
    }

    public String toString() {
        return generateString(root, new ArrayList<Boolean>());
    }

    private String generateString(TreeNode<T> startingNode, ArrayList<Boolean> includeLines) {
        StringBuilder sb = new StringBuilder();
        includeLines.add(true);
        for (int i = 0; i < startingNode.getChildren().size(); i++) {
            TreeNode<T> t = startingNode.getChildren().get(i);
            /*/
            for (int j = 0; j < includeLines.size(); j++) {
                if (includeLines.get(j)) {
                    sb.append("|    ");
                } else sb.append("     ");
            }
            sb.append("\n");
            */
            for (int j = 0; j < includeLines.size(); j++) {
                if (includeLines.get(j)) {
                    if (j == includeLines.size() - 1) sb.append("|----");
                    else sb.append("|    ");
                } else sb.append("     ");
            }
            if (i == startingNode.getChildren().size() - 1) includeLines.set(includeLines.size() - 1, false);
            sb.append(t.getData().toString());
            sb.append(" (");
            sb.append(t.getPassingFrequency());
            sb.append(" / ");
            sb.append(t.getFrequency());
            sb.append(")\n");
            sb.append(generateString(t, includeLines));
        }
        includeLines.remove(includeLines.size() - 1);
        return sb.toString();
    }

}
