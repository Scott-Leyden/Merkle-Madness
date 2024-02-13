public class MerkleManager {
    public static volatile String userWord;
    public static String sExpectedRoot;
    public static String sMerkleRoot = null;
    public static int iStrikes = 0;

    public void Manage(){
        Util oUtil = new Util();
        sExpectedRoot = oUtil.promptUser("Enter expected merkle root hash");

        // Create thread objects
        MerkleThread oMerkleThread = new MerkleThread();
        RogueThread oRogueThread = new RogueThread();
        MonitorThread oMonitorThread = new MonitorThread();

        // Assign + start threads
        Thread oThread1 = new Thread(oMerkleThread);
        Thread oThread2 = new Thread(oRogueThread);
        Thread oThread3 = new Thread(oMonitorThread);
        oThread1.start();
        oThread2.start();
        oThread3.start();

        while (true){
            userWord = oUtil.promptUser("Enter word");
        }

    }

    public static synchronized String grabWord(){
        String tempWord = userWord;
        userWord = null;
        return tempWord;
    }
}
