/**
 * Problem desc in https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicate {

    public static int removeDuplicates(int[] nums) {
        int pivot = 0;
        for (int i = 1 ; i < nums.length ; i ++ ){
            if(nums[pivot] == nums[i]){
                continue;
            }else{
                nums[pivot+1] = nums[i];
                pivot++;
            }
        }


        return pivot+1;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1,1,1,2,3,3,5,7,8};

        int len = removeDuplicates(nums);
        System.out.print("After removing duplicate: ");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
