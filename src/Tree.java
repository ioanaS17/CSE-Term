import java.util.ArrayList;

public class Tree {

    TreeNode root;

    Tree() {
        root = new TreeNode(null, null);
    }

    public TreeNode addNode(String data, TreeNode parent) {
        if (parent == null) parent = root;
        TreeNode newNode = new TreeNode(data, parent);
        newNode = parent.addChild(newNode);
        return newNode;
    }

    public void compress(TreeNode startNode) {
        if (startNode == null) startNode = root;
        for (TreeNode t : startNode.getChildren()) {
            compress(t);
        }
        if (startNode.getFrequency() == 0 && startNode.getChildren().size() == 1) {
            startNode.mergeData(startNode.getChildren().get(0));
        }
    }

    public String toString() {
        return generateString(root, new ArrayList<Boolean>());
    }

    private String generateString(TreeNode startingNode, ArrayList<Boolean> includeLines) {
        StringBuilder sb = new StringBuilder();
        includeLines.add(true);
        for (int i = 0; i < startingNode.getChildren().size(); i++) {
            TreeNode t = startingNode.getChildren().get(i);
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
            sb.append(t.getData());
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
