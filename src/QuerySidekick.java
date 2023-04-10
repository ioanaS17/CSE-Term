import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;;

/*

  Authors (group members):
  Email addresses of group members:
  Group name:

  Course:
  Section:

  Description of the overall algorithm:


*/


public class QuerySidekick
{
    Tree<String> searchTree = new Tree<String>();
    String[] guesses = new String[5];  // 5 guesses from QuerySidekick

    // initialization of ...
    public QuerySidekick()
    {

    }

    // process old queries from oldQueryFile
    //
    // to remove extra spaces with one space
    // str2 = str1.replaceAll("\\s+", " ");
    public void processOldQueries(String oldQueryFile)
    {
        File file = new File(oldQueryFile);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR:\t Old query file not found");
            return;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replaceAll("\\s+", " ");
            String[] tokens = line.split(" ");
            TreeNode<String> lastNode = null;
            for (int i = 0; i < tokens.length; i++) {
                String s = tokens[i];
                lastNode = searchTree.addNode(s, lastNode);
                lastNode.incrementPassingFrequency();
                if (i == tokens.length - 1) lastNode.incrementFrequency();
            }
        }

        String treeString = searchTree.toString();

        String treeFileName = oldQueryFile.substring(0, oldQueryFile.length() - 4) + "Tree.txt";
        FileWriter fw;
        try {
            fw = new FileWriter(treeFileName);
            fw.write(treeString);
            fw.close();
        } catch (IOException e) {
            System.out.println("ERROR:\t Unable to save tree representation of old queries to \"" + treeFileName + "\"");
        }


        scanner.close();
    }

    // based on a character typed in by the user, return 5 query guesses in an array
    // currChar: current character typed in by the user
    // currCharPosition: position of the current character in the query, starts from 0
    public String[] guess(char currChar, int currCharPosition)
    {
	
        return guesses;
    }

    // feedback on the 5 guesses from the user
    // isCorrectGuess: true if one of the guesses is correct
    // correctQuery: 3 cases:
    // a.  correct query if one of the guesses is correct
    // b.  null if none of the guesses is correct, before the user has typed in 
    //            the last character
    // c.  correct query if none of the guesses is correct, and the user has 
    //            typed in the last character
    // That is:
    // Case       isCorrectGuess      correctQuery   
    // a.         true                correct query
    // b.         false               null
    // c.         false               correct query
    public void feedback(boolean isCorrectGuess, String correctQuery)        
    {

    }

}
