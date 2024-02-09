import java.util.ArrayList;

public class MerkleThread implements Runnable {
    public static volatile ArrayList<String> sGrabbedWords;
    private int iMerkleTreeInputs = 4;
    public void run(){
        Util oUtil = new Util();
        sGrabbedWords = new ArrayList<>();

        while (true){
            oUtil.sleepRandomTime("Merkle");
            String sTempWord = MerkleManager.grabWord();

            if (sTempWord != null){
                System.out.println("Merkle has grabbed a word.");
                sGrabbedWords.add(sTempWord);
                if (sGrabbedWords.size() == iMerkleTreeInputs){
                    MerkleManager.sMerkleRoot = oUtil.getMerkleRoot(sGrabbedWords);
                }
            }

        }

    }
}