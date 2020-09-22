import util.TrieNode;

public class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setWord(true);
    }


    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isWord();
    }

    public boolean delete(String word) {
        TrieNode current = root;
        TrieNode nodeToDeleteFrom = root;
        char charToDeleteFrom = word.charAt(0);
        boolean canDeleteFromLastNode = true;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }

            if (shouldDelete(node,word,i)){
                if(!canDeleteFromLastNode){
                    nodeToDeleteFrom = current;
                }
                canDeleteFromLastNode = true;

            }else{
                canDeleteFromLastNode = false;
            }

            current = node;

        }

        if (!current.isWord()) {
            return false;
        }else{
            current.setWord(false);

            if(nodeToDeleteFrom!=null){
                nodeToDeleteFrom.getChildren().remove(charToDeleteFrom);
            }
            return true;
        }
    }

    public void printTree(TrieNode node){
        node.getChildren().forEach((k,v)->
        {
            System.out.print(k);
            if(v.isWord()){
                System.out.println("\n");
            }
            printTree(v);
        });
    }

    private boolean shouldDelete(TrieNode node, String word, int idx){
        if(node.getChildren().size() > 1 ){
            return false;
        }

        if(idx < word.length() - 1 && node.isWord()){
            return false;
        }

        return true;
    }

}
