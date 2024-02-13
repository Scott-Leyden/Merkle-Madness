import java.security.SecureRandom;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

public class Util {
    public String getMerkleRoot(ArrayList<String> sWords){
        // Coded to 7 nodes
        MerkleNode oNode1 = new MerkleNode();
        MerkleNode oNode2 = new MerkleNode();
        MerkleNode oNode3 = new MerkleNode();
        MerkleNode oNode4 = new MerkleNode();
        MerkleNode oNode5 = new MerkleNode();
        MerkleNode oNode6 = new MerkleNode();
        MerkleNode oNode7 = new MerkleNode();

        // Create Merkle Leafs
        oNode1.setsHash( generateHash( sWords.get(0)) );
        oNode2.setsHash( generateHash( sWords.get(1)) );
        oNode3.setsHash( generateHash( sWords.get(2)) );
        oNode4.setsHash( generateHash( sWords.get(3)) );

        // Combination of Merkle Nodes
        populateMerkleNode(oNode5, oNode1, oNode2);
        populateMerkleNode(oNode6, oNode3, oNode4);
        populateMerkleNode(oNode7, oNode5, oNode6); // ***** Merkle Root *****

        return oNode7.getsHash();
    }

    private void populateMerkleNode(MerkleNode oNode,MerkleNode oNodeLeft, MerkleNode oNodeRight){
        oNode.setoLeft(oNodeLeft);
        oNode.setoRight(oNodeRight);
        oNode.setsHash(generateHash(oNode.getoLeft().getsHash() + oNode.getoRight().getsHash() ));
    }

    public synchronized String generateHash(String sOriginal){

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(
                    sOriginal.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < btEncodedhash.length; i++) {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch(Exception ex){

            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }

    public String promptUser(String sQuestion){
        JOptionPane oQuestion  = new JOptionPane();
        return oQuestion.showInputDialog(sQuestion);
    }

    public void sleepRandomTime(String sThreadName){

        // Gets random number between 0 and 5 and then adds 3, meaning between 3 and 8 now.
        int iSleepTime = new SecureRandom().nextInt(5) + 3;

        System.out.println(sThreadName + " sleeping for " + iSleepTime + " seconds.");
        sleep(iSleepTime);
    }

    public void sleep(int iSeconds){
        try {
            Thread.sleep(iSeconds * 1000);
        } catch (Exception ex) {

        }
    }
}
