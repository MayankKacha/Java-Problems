import java.util.Scanner;

public class test{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ranked=sc.nextInt();
        int[] r=new int[ranked];
        for(int i=0;i<ranked;i++){
            r[i]=sc.nextInt();
        }
        int player=sc.nextInt();
        int[] p=new int[player];
        for(int i=0;i<ranked;i++){
            p[i]=sc.nextInt();
        }
        int[] ans=new int[player];
        for(int i=0;i<player;i++){
            ans[i]=searchInsert(r,p[i]);
        }
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

      
    }
    public static int searchInsert(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while( low <= high){
            int mid= (low+high)/2;
            if(nums[mid] == target){
                return mid;
            } else if(target > nums[mid]){
                low= mid+1;
            } else{
                high= mid-1;
            }
        }
        
        return low+1;
    }
}