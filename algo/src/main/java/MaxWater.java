/**
 * Problem desc is in https://leetcode.com/problems/container-with-most-water/
 */
public class MaxWater {
    public static  int maxArea(int[] height) {

        int currentMax = 0;
        int overAllMax = 0;
        int leftMax = 0;
        int rightMax = 0;

        for (int i=0; i< height.length; i ++) {
            System.out.println("i=" + i);
            for(int j = height.length-1; j > i ; j--){
                if(height[j] >= height [i]){
                    leftMax = height[i] * (j-i);
                    break;
                }

            }
            System.out.println(leftMax);

            for(int k = 0; k < i; k++){
                if(height[k] >= height[i]){
                    rightMax = height[i] * (i - k);
                    break;
                }
            }

            currentMax = Math.max(leftMax,rightMax);

            System.out.println(currentMax);
            if(currentMax > overAllMax){
                overAllMax = currentMax;
            }

            System.out.println("overall max " + overAllMax);
        }

        return overAllMax;

    }


    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,1}));
    }
}
