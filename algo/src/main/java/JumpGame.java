import java.util.ArrayList;
import java.util.List;

/**
 * Problem desc in https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame {

    public static int canJump2(int[] nums) {

        int bestJumpPoint = 0;
        int steps = 1;

        if (nums.length < 2) {
            return 0;
        }

        if (nums[0] >= nums.length - 1) {
            return 1;
        }

        for (int nextBestJumpPoint = bestJumpPoint; nextBestJumpPoint < nums.length; ) {
            for (int k = bestJumpPoint + 1; k <= bestJumpPoint + nums[bestJumpPoint] && k < nums.length; k++) {

                if (k < nums.length - 1 && nums[k] + k >= nextBestJumpPoint + nums[nextBestJumpPoint] && nums[k] != 0) {
                    boolean canJump = false;
                    for (int next = k + 1; next <= nums[k] + k; next++) {
                        if (nums[next] != 0 || next > nums.length - 2) {
                            canJump = true;
                            break;
                        }
                    }
                    if (canJump) {
                        nextBestJumpPoint = k;
                    }
                    System.out.println("nextBestJumpPoint = " + nextBestJumpPoint);
                }

            }

            System.out.println(" bestJumpPoint = " + bestJumpPoint + " nextBestJumpPoint = " + nextBestJumpPoint + " nums[bestJumpPoint]=" + nums[bestJumpPoint] + " nums[nextBestJumpPoint]=" + nums[nextBestJumpPoint]);

            bestJumpPoint = nextBestJumpPoint;
            ++steps;

            if (nums[nextBestJumpPoint] + nextBestJumpPoint >= nums.length - 1) {
                System.out.println("exist here: " + nextBestJumpPoint);
                return steps;
            }


        }

        return steps;

    }


    public static boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length == 1) {
            return true;
        }

        List<Integer> indexOfZeros = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                indexOfZeros.add(i);
            }
        }

        for (Integer indexOfZero : indexOfZeros) {
            boolean canJumpOver = false;
            for (int j = 0; j < indexOfZero; j++) {
                int k = nums[j] - (indexOfZero - j);
                if (k > 0 || (k == 0 && indexOfZero == nums.length - 1)) {
                    canJumpOver = true;
                    break;
                }
            }

            if (!canJumpOver) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        //System.out.println(canJump(new int[]{2,2,0,1}));
        //System.out.println(canJump2(new int[]{2,1,3,4,1,1,1,1,1,0}));
        //System.out.println(canJump2(new int[]{5,9,3,2,1,0,2,3,3,2,0,0}));
        // System.out.println(canJump2(new int[]{1,1,1,1}));
        //System.out.println(canJump2(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
        System.out.println(canJump2(new int[]{2, 1, 9, 5, 9, 7, 6, 4, 8, 3, 2, 2, 2, 1, 9, 1, 7, 9, 7, 0, 7, 5, 8, 2, 1, 3, 2, 4, 1, 9, 5, 4, 0, 6, 1, 1}));
    }
}
