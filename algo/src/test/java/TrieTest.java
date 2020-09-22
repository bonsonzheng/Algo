import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TrieTest {

    Trie trie = new Trie();

    @Before
    public void setup() {

        trie.insert("programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("off");
        trie.insert("life");
        trie.insert("rich");
        trie.insert("ricardo");

    }

    @Test
    public void testInsertAndSearch() {
        assertTrue(trie.find("programming"));
        assertTrue(trie.find("life"));
        assertFalse(trie.find("program"));
    }

    @Test
    public void testDelete() {
        trie.delete("off");
        assertFalse(trie.find("off"));
        assertTrue(trie.find("of"));
    }
}