import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TreeBuilder {

    private TreeBuilderNode root;

    TreeBuilder() {
        root = new TreeBuilderNode(null, null);
    }

    public TreeBuilderNode addNode(String data, TreeBuilderNode parent) {
        if (parent == null) parent = root;
        TreeBuilderNode newNode = new TreeBuilderNode(data, parent);
        newNode = parent.addChild(newNode);
        return newNode;
    }

    public void compress(TreeBuilderNode startNode) {
        if (startNode == null) startNode = root;
        for (TreeBuilderNode t : startNode.getChildren()) {
            compress(t);
        }
        if (startNode.getFrequency() == 0 && startNode.getChildren().size() == 1) {
            startNode.mergeData(startNode.getChildren().get(0));
        }
    }

    public TreeBuilderNode getRoot() { return root; }

    public String toString() {
        return generateString(root, new ArrayList<Boolean>());
    }

    private String generateString(TreeBuilderNode startingNode, ArrayList<Boolean> includeLines) {
        StringBuilder sb = new StringBuilder();
        includeLines.add(true);
        for (int i = 0; i < startingNode.getChildren().size(); i++) {
            TreeBuilderNode t = startingNode.getChildren().get(i);
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

    public void writeToFile(String filename) {
        String treeString = toString();

        String treeFileName = filename.substring(0, filename.length() - 4) + "Tree.txt";
        FileWriter fw;
        try {
            fw = new FileWriter(treeFileName);
            fw.write(treeString);
            fw.close();
        } catch (IOException e) {
            System.out.println("ERROR:\t Unable to save tree representation of old queries to \"" + treeFileName + "\"");
        }
    }

}
