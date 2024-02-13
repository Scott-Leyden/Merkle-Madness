public class RogueThread implements Runnable {
    public void run(){
        Util oUtil = new Util();
        while (true){
            oUtil.sleepRandomTime("Rogue");
            String tempWord = MerkleManager.grabWord();

            if (tempWord != null){
                MerkleManager.iStrikes += 1;
                System.out.println("Rogue has taken the word! Strike!");
            }
        }
    }

}
