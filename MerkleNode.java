public class MerkleNode {
    private MerkleNode oLeft;
    private MerkleNode oRight;
    private String sHash;

// Gets //
    public MerkleNode getoLeft() {
        return oLeft;
    }
    public MerkleNode getoRight() {
        return oRight;
    }
    public String getsHash() {
        return sHash;
    }
// Sets //
    public void setoLeft(MerkleNode oLeft) {
        this.oLeft = oLeft;
    }
    public void setoRight(MerkleNode oRight) {
        this.oRight = oRight;
    }
    public void setsHash(String sHash) {
        this.sHash = sHash;
    }


}
