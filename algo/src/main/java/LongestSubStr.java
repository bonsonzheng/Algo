import java.util.HashSet;
import java.util.Set;

/**
 * Problem desc in https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubStr {

    public static int lengthOfLongestSubstring2(String s) {
        int longest = 0, slow = 0, fast = 0;
        Set<Character> set = new HashSet<>();

        while(fast < s.length()){
            if(!set.contains(s.charAt(fast))){
                set.add(s.charAt(fast++));
                longest = Math.max(longest, set.size());
            }else{
                set.remove(s.charAt(slow++));
            }
        }

        return longest;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("acbab"));
        System.out.println(lengthOfLongestSubstring2("abcdefg"));
        System.out.println(lengthOfLongestSubstring2("aa"));

    }
}
