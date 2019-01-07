import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem desc in https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestParentheses {

    public static int longestValidParentheses(String s) {
        List<Integer> indexList = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }

            if (s.charAt(i) == ')') {
                if (!stack.empty()) {
                    Integer pop = stack.pop();
                    indexList.add(pop);
                    indexList.add(i);
                }
            }
        }

        int longest = countLongest(s, indexList);


        return longest;
    }

    private static int countLongest(String s, List<Integer> indexList) {
        int found = 0;
        int longest = 0;
        for (int j = 0; j <= s.length(); j++) {
            if (!indexList.contains(j)) {
                found = 0;
            } else {
                found++;
            }
            longest = Math.max(longest, found);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")("));
        System.out.println(longestValidParentheses("(()())()(()"));
    }
}
