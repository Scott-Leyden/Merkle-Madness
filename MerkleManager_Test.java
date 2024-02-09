// * Ian Brown
// * Assadullah Hussaini
// * Scott Leyden
// * Savel Moshi

import java.util.ArrayList;

public class MerkleManager_Test {
    public static void main(String[] args) {
        Util oUtil = new Util();
        ArrayList<String> words = new ArrayList<>();

        words.add("word1");
        words.add("word2");
        words.add("word3");
        words.add(oUtil.promptUser("Add word"));

        String merkle = oUtil.getMerkleRoot(words);
        System.out.println(merkle);
        System.out.println("0264d08de65fcd9ee5767a3c8e87a56a6f554137082898a10fd228331c092ffa");
    }
}