package Test;



import java.util.HashMap;

public class Main {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int [] aa=new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if(map.containsKey(target-nums[i])){
                aa[0]=i;
                aa[1]= map.get(target-nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return aa;
    }



    public static void main(String [] args){
     System.out.println(Float.parseFloat("1.99999999"));
    }
}
