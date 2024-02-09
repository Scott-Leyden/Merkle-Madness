public class MonitorThread implements Runnable {
    public void run(){
        Util oUtil = new Util();
        while (true){
            if (MerkleManager.sMerkleRoot != null){
                if (MerkleManager.sExpectedRoot.equals(MerkleManager.sMerkleRoot)){
                    System.out.println("You Win!\n" + MerkleManager.sMerkleRoot);
                    System.exit(0);
                } else {
                    System.out.println("Incorrect merkle root. You Lose. \n" + MerkleManager.sMerkleRoot);
                    System.exit(0);
                }
            }

            if (MerkleManager.iStrikes == 3) {
                System.out.println("3 Strikes. You Lose.");
                System.exit(0);
            }
            oUtil.sleep(1);
        }
    }
}
